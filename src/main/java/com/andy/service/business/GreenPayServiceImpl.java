package com.andy.service.business;

import com.andy.model.RequestGateway;
import com.andy.model.RequestGatewayGreen;
import com.andy.model.ResponseGateway;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("greenpay")
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

    @Override
    public ResponseGateway send(RequestGateway requestGateway) {

        return null;
    }
}
