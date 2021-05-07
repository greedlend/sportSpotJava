package com.andy.service.business;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Slf4j
@Service
public class AllpayServiceImpl implements DonateService{

    @Override
    public String htmlMethod() {
        log.info("override");
        return "this allpay payment";
    }

    @Override
    public String directUrl() {
        return null;
    }

    @Override
    public Boolean checkParams(String jsonBody){return null;}
}
