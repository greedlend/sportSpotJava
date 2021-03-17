package com.andy.controller;

import com.andy.config.BaseConfiguration;
import com.andy.model.Spot;
import com.andy.model.input.SpotInput;
import com.andy.service.database.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private SpotService spotService;

    @RequestMapping(value= "/list")
    public String gateWay() {
        Properties properties = System.getProperties();
        properties.list(System.out);
        return baseConfig.getHost();
    }

    @RequestMapping(value= "/adds",method = RequestMethod.POST)
    public String addsSpot(@RequestBody SpotInput spot, HttpServletRequest request, HttpServletResponse response) {

        Spot result = spotService.addsSpot(spot);
        return null == result? "failed":"ok";
    }
}
