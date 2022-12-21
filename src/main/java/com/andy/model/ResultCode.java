package com.andy.model;

public enum ResultCode {

    SS(1, ""),
    SA(2, "")
    ;

    private String code;
    private int value;

    ResultCode(int value, String code) {
        this.value = value;
        this.code = code;
    }

    public int getValue() {return value;}
    public String getCode() {
        return code;
    }
}
