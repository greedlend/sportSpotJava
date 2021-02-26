package com.andy.service.graphqls.resolver;

import com.andy.model.UserBase;
import com.andy.model.UserExtends;
import com.andy.service.database.UserExtendsService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
@Slf4j
@Component
public class UserExtendsResolver implements GraphQLResolver<UserBase> {

    @Autowired
    private UserExtendsService userExtendsService;

    public UserExtends userExtends(UserBase userBase) {
        return userExtendsService.getUserExtends(userBase);
    }
}
