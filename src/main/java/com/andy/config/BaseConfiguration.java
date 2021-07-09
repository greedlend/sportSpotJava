package com.andy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/26
 * @Proposal:
 */
@Configuration
public class BaseConfiguration {


    @Value("${test1026.host}")
    private String host;

    @Value("${test1026.name}")
    private String name;

    @Value("${test1026.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
