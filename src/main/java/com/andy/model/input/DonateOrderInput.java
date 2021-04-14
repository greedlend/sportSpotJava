package com.andy.model.input;

import com.andy.utils.DateUtils;
import lombok.Data;

/**
 * @Author: Lim, Andy
 * @Date: 2021/4/14
 * @Proposal:
 */
@Data
public class DonateOrderInput extends OrderInput{

    private Integer provider;

    private String donator;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb      .append("{Order:").append(this.getOrderId())
                .append(", Amount:").append(this.getAmount())
                .append(", Provider:").append(this.provider)
                .append(", Donator:").append(this.donator)
                .append(", CreateTime:").append(DateUtils.dateToStr(this.getCreateTime(), "yyyy-MM-dd hh:mm:ss"))
                .append(", UpdateTime:").append(DateUtils.dateToStr(this.getUpdateTime(), "yyyy-MM-dd hh:mm:ss"))
                .append("}");
        return sb.toString();
    }
}
