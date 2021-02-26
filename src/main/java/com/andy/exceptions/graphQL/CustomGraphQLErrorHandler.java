package com.andy.exceptions.graphQL;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/10
 * @Proposal: 自定義GraphQL例外處理
 */
@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
     return errors;
    }
}
