package com.andy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultCode {

    private String code;

    private String msg;

    public ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
