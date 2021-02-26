package com.andy.service.graphqls.resolver;

import com.andy.context.dataloader.DataLoaderRegistryFactory;
import com.andy.model.UserBase;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/17
 * @Proposal:
 */
@Slf4j
@Component
public class UserBaseResolver implements GraphQLResolver<UserBase> {

    public CompletableFuture<BigDecimal> balance(UserBase userBase, DataFetchingEnvironment environment) throws InterruptedException {

        log.info("User:{}, get balance", userBase.getUsername());
        DataLoader<String, BigDecimal> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.BALANCE_DATA_LOADER);
        return dataLoader.load(userBase.getUuid());
    }
}
