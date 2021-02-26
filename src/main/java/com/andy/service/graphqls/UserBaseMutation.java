package com.andy.service.graphqls;

import com.andy.model.UserBase;
import com.andy.model.input.UserBaseInput;
import com.andy.service.database.UserBaseService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/29
 * @Proposal:
 */
@Component
public class UserBaseMutation implements GraphQLMutationResolver {

    @Autowired
    private UserBaseService userBaseService;

    public UserBase newUserBase(UserBaseInput userBaseInput) {
        return this.userBaseService.newUserBase(userBaseInput);
    }
}
