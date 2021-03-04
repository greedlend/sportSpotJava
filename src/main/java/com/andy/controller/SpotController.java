package com.andy.controller;

import com.andy.config.BaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @Author: Lim, Andy
 * @Date: 2021/3/2
 * @Proposal:
 */
//Spring4之后新加入的注解，原来返回json需要@ResponseBody和@Controller配合。
//即@RestController 是@ResponseBody和@Controller的组合注解。
@RestController
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    private BaseConfiguration baseConfig;

    @RequestMapping(value= "/list")
    public String gateWay() {
        Properties properties = System.getProperties();
        properties.list(System.out);
        return baseConfig.getHost();
    }
}
