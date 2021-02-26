package com.andy.service.graphqls.resolver;

import com.andy.model.Organization;
import com.andy.model.UserBase;
import com.andy.service.database.OrganizationService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
@Slf4j
@Component
public class OrganizationResolver implements GraphQLResolver<UserBase> {

    @Autowired
    private OrganizationService organizationService;

    public Organization organization(UserBase userBase) {
        return this.organizationService.getOrganization(userBase);
    }


}
