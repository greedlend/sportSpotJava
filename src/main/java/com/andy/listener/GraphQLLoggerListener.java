package com.andy.listener;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/16
 * @Proposal:
 */
@Slf4j
@Component
//@RequiredArgsConstructor
public class GraphQLLoggerListener implements GraphQLServletListener {

   private final Clock clock;

   public GraphQLLoggerListener(Clock clock) {
       this.clock = clock;
   }

    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {

        var startTime = Instant.now(clock);
        return new RequestCallback() {
            @Override
            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                log.info("GraphQL Request Succesed");
            }

            @Override
            public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
                log.info("GraphQL Request failed");
            }

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                log.info("GraphQL Request ends at {}", Duration.between(startTime,Instant.now(clock)));
            }
        };
    }
}
