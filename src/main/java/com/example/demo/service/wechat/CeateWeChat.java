package com.example.demo.service.wechat;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.CreateChatGroup;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class CeateWeChat {

    private static String CeateWeChatUrl = "https://qyapi.weixin.qq.com/cgi-bin/appchat/create?access_token=%s";

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public String CeateWeChatpost(String access_token,String name,String chatid) {
        OkHttpClient client = new OkHttpClient();
        CreateChatGroup createChatGroup = new CreateChatGroup();
        createChatGroup.setName(name);
        createChatGroup.setChatid(chatid);
        createChatGroup.setOwner("FuYi");
        List<String> userList = new ArrayList<>();// 添加用户id
        createChatGroup.setUserlist(userList);
        String json = JSONObject.toJSONString(createChatGroup);

        RequestBody body =RequestBody.create(json,JSON);
        Request request = new Request.Builder()
                .url(String.format(CeateWeChatUrl, access_token))
                .post(body)
                .build();
        try {
            try (Response response = client.newCall(request).execute()) {
                json=response.body().string();
//                jsonObject = JSONObject.parseObject(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
