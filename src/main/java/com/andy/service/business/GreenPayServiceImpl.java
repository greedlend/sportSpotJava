package com.andy.service.business;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class GreenPayServiceImpl implements DonateService{

    @Override
    public String htmlMethod() {
        return "this green payment";
    }

    @Override
    public String directUrl() {
        return null;
    }

    @Override
    public Boolean checkParams(String jsonBody){return null;}
}
