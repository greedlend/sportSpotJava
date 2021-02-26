package com.andy.exceptions.graphQL;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/10
 * @Proposal:
 */
@Component
public class ExceptionHandlerGraphQL {

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(GraphQLException e) {
        return new ThrowableGraphQLError(e);
    }
}
