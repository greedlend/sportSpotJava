package com.andy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Clock;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/30
 * @Proposal:
 */
@Component
public class ClockConfig {


    // 找出實作方式annotation
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
