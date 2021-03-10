package com.andy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    private static Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @RequestMapping(value= "/plusInSpot")
    public String gateWay() {
        logger.info("adds one in spot");


        return "";
    }
}
