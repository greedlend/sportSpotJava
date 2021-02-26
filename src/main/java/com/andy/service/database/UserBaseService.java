package com.andy.service.database;

import com.andy.enums.Pagination;
import com.andy.model.UserBase;
import com.andy.model.input.UserBaseInput;
import com.andy.repository.UserBaseRepository;
import com.andy.utils.GeneratorUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/29
 * @Proposal:
 */
@Service
public class UserBaseService {

    @Autowired
    private UserBaseRepository userBaseRepository;

    private final Clock clock = Clock.systemUTC();

    @Transactional
    public UserBase newUserBase(UserBaseInput userBaseInput) {

        if(null == userBaseInput) {
            return null;
        }

        String id = GeneratorUtils.generateUUID();
        String tempPwd = GeneratorUtils.generateTempPassword();
        ZonedDateTime createTime = ZonedDateTime.now(clock);

        UserBase upperUserBase = !Strings.isBlank(userBaseInput.getUpperId())? userBaseRepository.getOne(userBaseInput.getUpperId()): null;

        UserBase userBase = new UserBase();
        userBase.setUuid(id);
        userBase.setPassword(tempPwd);
        userBase.setEmail(userBaseInput.getEmail());
        userBase.setCreateTime(createTime);
        userBase.setUsername(userBaseInput.getUsername());
        userBase.setUpper(upperUserBase);

        return this.userBaseRepository.saveAndFlush(userBase);
    }
//    public UserBase saveUserBase(String email) {}
//    deleteUserBase(uuid: String!) : Boolean

    @Transactional(readOnly = true)
    public List<UserBase> findAllUserBases() {
        return this.userBaseRepository.findAll();
    }


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<UserBase> findAllUserBasesAfter(Map<String, Object> pageArgsMap) {

        String cursor = null == pageArgsMap.get("cursor")? null : pageArgsMap.get("cursor").toString();
        Integer limit = Integer.valueOf(pageArgsMap.remove("limit").toString());
        Integer direction = Integer.valueOf(pageArgsMap.remove("direction").toString());
        //根據排序方式(order by)，會決定where中的條件式( > || < )
        //ASC進行下一頁，使用 uuid > 傳參
        //ASC進行上一頁，使用 uuid < 傳參
        //DESC進行下一頁，使用uuid < 傳參
        //DESC進行上一頁，使用uuid > 傳參
        //目前以uuid ASC為測試

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserBase> cq = cb.createQuery(UserBase.class);
        Root<UserBase> root = cq.from(UserBase.class);
        List<Predicate> predicates = new ArrayList<>();
        if (null != cursor) {
            if(direction == Pagination.NEXT_PAGE.value()) {
                predicates.add(cb.greaterThan(root.get("uuid"), cursor));
            }else if(direction == Pagination.PREVIOUS_PAGE.value()) {
                predicates.add(cb.lessThan(root.get("uuid"), cursor));
            }
        }

        cq.select(root)
                .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        return entityManager.createQuery(cq).setMaxResults(limit).getResultList();
    }

    @Transactional(readOnly = true)
    public Long count() {
        return this.userBaseRepository.count();
    }

    @Transactional(readOnly = true)
    public UserBase getUserBase(String id) {
        return this.userBaseRepository.findById(id).get();
    }
}