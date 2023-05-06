package com.film.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseData {

    //返回成功
    public static final String STATUS_SUCCESS = "SUCCESS";
    //返回失败
    public static final String STATUS_FAIL = "FAIL";
    //返回为空，文本框为空返回
    public static final String STATUS_NULL = "NULL";
    //已存在，用于用户注册返回
    public static final String STATUS_EXISTS = "EXISTS";
    //返回管理员成功登录
    public static final String STATUS_ADMIN = "ADMIN";
    //返回用户成功登录
    public static final String STATUS_USER = "USER";

}
