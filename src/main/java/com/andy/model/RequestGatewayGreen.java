package com.andy.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestGatewayGreen{

    private String brandName;

    private BigDecimal amount;

    RequestGatewayGreen(RequestGateway rg) {
        this.amount =rg.getAmount();
    }
}
