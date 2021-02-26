package com.andy.controller;

import com.andy.config.BaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/26
 * @Proposal:
 */
@RestController
public class BaseController {

    @Autowired
    private BaseConfiguration baseConfig;

    @RequestMapping(value= "/gateway")
    public String gateWay() {
        Properties properties = System.getProperties();
        properties.list(System.out);
        return baseConfig.getHost();
    }
}
