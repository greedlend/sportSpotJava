package com.andy.service.graphqls;

import com.andy.context.CustomGraphQLContext;
import com.andy.enums.Pagination;
import com.andy.model.Organization;
import com.andy.model.UserBase;
import com.andy.service.database.OrganizationService;
import com.andy.service.database.UserBaseService;
import com.andy.utils.CursorUtil;
import graphql.GraphQLException;
import graphql.GraphqlErrorException;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/29
 * @Proposal:
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserBaseQuery implements GraphQLQueryResolver {

    private final CursorUtil cursorUtil;

    @Autowired
    private UserBaseService userBaseService;

    public List<UserBase> findAllUserBases() {
        return this.userBaseService.findAllUserBases();
    }

    public Integer count() {
        return null != this.userBaseService.count()? this.userBaseService.count().intValue(): 0;
    }

    public UserBase userBase(UUID id, DataFetchingEnvironment dataFetchingEnvironment) {
        log.info("DataFetchingEnvironment ...");

        CustomGraphQLContext customGraphQLContext = dataFetchingEnvironment.getContext();

        log.info("User_id:{}", customGraphQLContext.getUserId());

        return this.userBaseService.getUserBase(id);
    }

    public Connection<UserBase> pageAllUserBases(Integer first, String after, String before, Integer last) throws UnsupportedEncodingException {

        Map<String, Object> pageArgsMap = checkPageArgs(first,after,before,last);

        boolean isPageArgsValid = ((boolean) pageArgsMap.get("isPageArgsValid"));
        if(!isPageArgsValid) {
            throw new RuntimeException("There is wrong match with the Args of Pagination");
        }

        Integer direction = Integer.valueOf(pageArgsMap.get("direction").toString());
        Integer limit = Integer.valueOf(pageArgsMap.get("limit").toString());
        List<UserBase> userBaseList = getUserBases(pageArgsMap);

        boolean isHasNextPage = userBaseList.size() > first;
        boolean isHasPreviousPage = after != null;
        if(direction == Pagination.NEXT_PAGE.value()) {
            isHasNextPage = userBaseList.size() > first;
            isHasPreviousPage = Strings.isNotBlank(after);
        }else if(direction == Pagination.PREVIOUS_PAGE.value()) {
            isHasNextPage = Strings.isNotBlank(before);
            isHasPreviousPage = userBaseList.size() > last;
        }


        /**
         * limit = first+1，加1表示多取1筆資料，用來確認是否有下一頁；判斷結束後刪除-1
         * */
        List<Edge<UserBase>> edgeList= userBaseList
                .stream()
                .map(userBase -> new DefaultEdge<>(userBase, cursorUtil.from(userBase.getUuid().toString())))
                .limit(limit)
                .collect(Collectors.toList());

        ConnectionCursor firstCursor = cursorUtil.getFirstCursor(edgeList);
        ConnectionCursor lastCursor = cursorUtil.getLastCursor(edgeList);
        PageInfo pageInfo = new DefaultPageInfo(firstCursor, lastCursor, isHasPreviousPage, isHasNextPage);

        log.info("got the datas");

        return new DefaultConnection<>(edgeList, pageInfo);
    }

    /**
     * 檢查Pagination參數
     * first及last之一必有 > 0
     * first有值，before不可有值
     * last有值，after不可有值
     * return 必要欄位map
     * */
    private Map<String, Object> checkPageArgs(Integer first, String after, String before, Integer last) {

        Map<String, Object> pageArgsMap = new HashMap<>();
        first = null == first ? 0 : first;
        last = null == last ? 0 : last;
        boolean isIllegalPageArgs = (0 == first && 0 == last)
                || (0 != first && Strings.isNotBlank(before))
                || (0 != last && Strings.isNotBlank(after) && Strings.isBlank(before));
        boolean isNextPage = 0 != first;
        boolean isPreviousPage = 0 != last;

        if(isIllegalPageArgs) {
            pageArgsMap.put("isPageArgsValid", Boolean.FALSE);
            return pageArgsMap;
        }

        if(isNextPage) {
            pageArgsMap.put("isPageArgsValid", Boolean.TRUE);
            pageArgsMap.put("direction", Pagination.NEXT_PAGE.value());
            pageArgsMap.put("cursor", after);
            pageArgsMap.put("limit", first);
            return pageArgsMap;
        }else {
            pageArgsMap.put("isPageArgsValid", Boolean.TRUE);
            pageArgsMap.put("direction", Pagination.PREVIOUS_PAGE.value());
            pageArgsMap.put("cursor", before);
            pageArgsMap.put("limit", last);
            return pageArgsMap;
        }
    }

    private List<UserBase> getUserBases(Map<String, Object> pageArgsMap) {
        Integer direction = Integer.valueOf(pageArgsMap.get("direction").toString());
        String cursor = null == pageArgsMap.get("cursor")? null : pageArgsMap.get("cursor").toString();
        String limit = pageArgsMap.remove("limit").toString();

        String decodedCursor = Strings.isNotBlank(cursor)? cursorUtil.decode(cursor): null;

        if(direction == Pagination.NEXT_PAGE.value()) {
            pageArgsMap.put("cursor", decodedCursor);
            pageArgsMap.put("limit", Integer.valueOf(limit) + 1);
        }else if(direction == Pagination.PREVIOUS_PAGE.value()) {
            pageArgsMap.put("cursor", decodedCursor);
            pageArgsMap.put("limit", Integer.valueOf(limit) + 1);
        }

        return this.userBaseService.findAllUserBasesAfter(pageArgsMap);
    }

    public DataFetcherResult<UserBase> getDataFetcherResult(UUID id) {

//        throw new RuntimeException("customized exception error");
        /**
         * Final result _直接回傳最後結果
         * */
        return DataFetcherResult
                .<UserBase>newResult()
                .data(this.userBaseService.getUserBase(id))
                .error(new GenericGraphQLError("test error"))
                .build();
    }

    /**
     * multi-thread 處理單一graphQL query
     * */
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<UserBase> executorGet(UUID id) {
        return CompletableFuture.supplyAsync(
                () -> {
                    return this.userBaseService.getUserBase(id);
                }
                , executorService);
    }
}
