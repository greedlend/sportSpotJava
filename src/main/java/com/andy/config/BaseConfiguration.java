package com.andy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/26
 * @Proposal:
 */
@Component
public class BaseConfiguration {

//    @Value("${testmain.name}")
//    private String mainName;

    @Value("${test1026.host}")
    private String host;

    @Value("${test1026.name}")
    private String name;

    @Value("${spring.datasource.url}")
    private String dbUrl;

//    public String getMainName() {
//        return mainName;
//    }
//
//    public void setMainName(String mainName) {
//        this.mainName = mainName;
//    }


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
}
