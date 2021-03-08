package com.andy.service.graphqls;

import com.andy.model.Organization;
import com.andy.service.database.OrganizationService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/13
 * @Proposal:
 */
@Slf4j
@Component
public class OrganizationQuery implements GraphQLQueryResolver {

    @Autowired
    private OrganizationService organizationService;

    public Organization organization(UUID uuid) {
        return this.organizationService.getOrganization(uuid);
    }

    public List<Organization> findAllOrganizations() {
        return this.organizationService.findList();
    }
}
