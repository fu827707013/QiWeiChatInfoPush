package com.example.demo.utils;

public enum AppStatusCode {
    Ok("成功", 0),
    Fail("系统异常", 1),
    BadRequest("非法请求", 10000),
    ClientNotFount("client不存在", 10001),
    ClientDisabled("client已被禁用", 10002),
    UnsupportedResponseType("不支持的response_type", 10003),
    UnsupportedScope("不支持的scope", 10004),
    RedirectUriFail("redirect_uri与client不匹配", 10005),
    GrantTypeFail("不支持的grant_type", 10006),
    CodeNotExist("code不存在", 10007),
    CodeExpired("code已过期", 10008),
    CodeIsUsed("code已经被使用了", 10009),
    UserNotAuthorize("该用户还未获得授权", 10010),
    TokenFail("获取token失败", 10011),
    TokenExpired("token已过期",10012),
    RefreshTokenNotFound("refresh_token不存在",10013),
    RefreshTokenExpired("refresh_token已过期",10014),
    UserValidFail("用户验证失败", 20001),
    ParamsValidFail("参数验证失败", 20002);

    private int code;
    private String value;

    AppStatusCode(String value, int code) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}
