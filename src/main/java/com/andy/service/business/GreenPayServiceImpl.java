package com.andy.service.business;

import com.andy.model.RequestGateway;
import com.andy.model.RequestGatewayGreen;
import com.andy.model.ResponseGateway;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("greenpay")
public class GreenPayServiceImpl implements DonateService{

    private final String greenpayUrl = "https://greenpay";

    @Override
    public String htmlMethod() {
        return "this green payment";
    }

    @Override
    public String directUrl() {
        return greenpayUrl;
    }

    @Override
    public Boolean checkParams(String jsonBody){
        Gson gson = new Gson();
        JSONObject jo = gson.fromJson(jsonBody, JSONObject.class);
        //todo:
        return true;
    }

    @Override
    public ResponseGateway send(RequestGateway requestGateway) {

//        String jsonResponse = greenpay.send(requestGateway);

        ResponseGateway rg = new ResponseGateway();
        return null;
    }
}
