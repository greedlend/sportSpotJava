package com.andy.service.business;

import com.andy.model.RequestGateway;
import com.andy.model.ResponseGateway;

public interface DonateService {

    String htmlMethod();

    String directUrl();

    Boolean checkParams(String params);

    ResponseGateway send(RequestGateway requestGateway);
}
