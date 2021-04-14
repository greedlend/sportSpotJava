package com.andy.model.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: Lim, Andy
 * @Date: 2021/4/14
 * @Proposal:
 */
@Data
public class OrderInput {

    private UUID orderId;

    private Double amount;

    private Date createTime;

    private Date updateTime;
}
