package com.andy.utils;

import com.andy.model.ResultCode;

public class ResponseUtil {

    public static Response<T> genResp(T data, ResultCode resultCode) {
        Response a = new Response();
        a.setCode(resultCode.getCode());
        a.setMsg(resultCode.getMsg);
        a.setDate(data);
        return a;
    }
}
