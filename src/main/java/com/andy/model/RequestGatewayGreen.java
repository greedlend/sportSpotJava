package com.andy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class RequestGatewayGreen extends RequestGateway{

    private String brandName;

    private BigDecimal amount;

    public RequestGatewayGreen(RequestGateway rg) {
        this.amount =rg.getAmount();
    }
}
