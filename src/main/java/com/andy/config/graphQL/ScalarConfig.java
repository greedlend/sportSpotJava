package com.andy.config.graphQL;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/30
 * @Proposal:
 */
@Configuration
public class ScalarConfig {

    @Bean
    public GraphQLScalarType date() {
        return ExtendedScalars.DateTime;
    }
}
