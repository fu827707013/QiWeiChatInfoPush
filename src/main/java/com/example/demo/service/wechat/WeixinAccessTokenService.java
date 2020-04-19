package com.example.demo.service.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import java.io.IOException;

/**
 * 处理企业微信AccessToken
 * @author laowang
 * @email open@xcloud.com
 */
@Service
public class WeixinAccessTokenService {

    //企业微信
    private static String WeixinTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";

    public String  getEnterpriseAccessToken(String corpid, String corpsecret) throws IOException {
        String accessToken = "";
        String url =  String.format(WeixinTokenUrl, corpid,corpsecret);
        String json ="";

        try{
            OkHttpClient okHttpClient = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .build();
            final Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            json= response.body().string();
        }catch (Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }

        JSONObject jsonObject = JSON.parseObject(json);
        if (jsonObject.getInteger("errcode")==0) {
            accessToken = jsonObject.getString("access_token");
        }

        return accessToken;
    }
}