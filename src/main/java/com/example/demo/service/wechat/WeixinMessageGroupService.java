package com.example.demo.service.wechat;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.MapInitializer;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 处理企业微信消息推送操作
 *
 * @author laowang
 * @email open@xcloud.com
 */
@Service
public class WeixinMessageGroupService {

    //企业微信
    public static final String URL_PATTERN = "https://qyapi.weixin.qq.com/cgi-bin/message/send" +
            "?access_token={{ACCESS_TOKEN}}";

    @Autowired
    private WeixinAccessTokenService weixinAccessTokenService;

    /**
     * 推送企业消息给用户
     *
     * @param agentId     应用ID
     * @param touser      成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
     * @param toparty     部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     * @param totag       标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     * @param msgtype     消息类型
     * @param initializer 消息主体参数参考 https://work.weixin.qq.com/api/doc#90000/90135/90236
     */
    public void send(String msgtype, String touser, String toparty, String totag, MapInitializer<String, String> initializer, String agentId) {

        //准备构造json
        JSONObject firstjsonObject = new JSONObject();
        JSONObject msgtypejsonObject = new JSONObject();
        //图文类json构造
        JSONArray jsonArray = new JSONArray();
        JSONObject secandjsonObject = new JSONObject();
        //填充消息参数
        Map<String, String> map = new HashMap<>();
        //填充图文类多节点参数
        List<Map<String, String>> list = new ArrayList<>();
        //构造通用消息参数json
        firstjsonObject.put("touser", touser);
        firstjsonObject.put("toparty", toparty);
        firstjsonObject.put("totag", totag);
        firstjsonObject.put("msgtype", msgtype);
        firstjsonObject.put("agentid", agentId);
        switch (msgtype) {
            case "text":
                initializer.init(map);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                firstjsonObject.put("text", msgtypejsonObject);
                firstjsonObject.put("safe", 0);
                break;
            case "image":
                initializer.init(map);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                firstjsonObject.put("image", msgtypejsonObject);
                firstjsonObject.put("safe", 0);
                break;
            case "voice":
                initializer.init(map);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                firstjsonObject.put("voice", msgtypejsonObject);
                break;
            case "video":
                initializer.init(map);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                firstjsonObject.put("video", msgtypejsonObject);
                firstjsonObject.put("safe", 0);
                break;
            case "file":
                initializer.init(map);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                firstjsonObject.put("file", msgtypejsonObject);
                firstjsonObject.put("safe", 0);
                break;
            case "textcard":
                initializer.init(map);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                firstjsonObject.put("textcard", msgtypejsonObject);
                break;
            case "news":
                initializer.initListMap(list);
                //构造消息主体json
                for (int i = 0; i <= list.size() - 1; i++) {
                    secandjsonObject = new JSONObject();
                    for (String paramName : list.get(i).keySet()) {
                        secandjsonObject.put(paramName, list.get(i).get(paramName));
                    }
                    jsonArray.add(secandjsonObject);
                }
                msgtypejsonObject.put("articles", jsonArray);
                firstjsonObject.put("news", msgtypejsonObject);
                break;
            case "mpnews":
                initializer.initListMap(list);
                //构造消息主体json
                for (int i = 0; i <= list.size() - 1; i++) {
                    secandjsonObject = new JSONObject();
                    for (String paramName : list.get(i).keySet()) {
                        secandjsonObject.put(paramName, list.get(i).get(paramName));
                    }
                    jsonArray.add(secandjsonObject);
                }
                msgtypejsonObject.put("articles", jsonArray);
                firstjsonObject.put("mpnews", msgtypejsonObject);
                break;
            case "markdown":
                initializer.init(map);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                firstjsonObject.put("markdown", msgtypejsonObject);
                break;
            case "miniprogram_notice":
                initializer.init(map);
                initializer.initListMap(list);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                //构造消息节点json
                for (int i = 0; i <= list.size() - 1; i++) {
                    secandjsonObject = new JSONObject();
                    for (String paramName : list.get(i).keySet()) {
                        secandjsonObject.put(paramName, list.get(i).get(paramName));
                    }
                    jsonArray.add(secandjsonObject);
                }
                msgtypejsonObject.put("content_item", jsonArray);
                firstjsonObject.put("miniprogram_notice", msgtypejsonObject);
                break;
            case "taskcard":
                initializer.init(map);
                initializer.initListMap(list);
                //构造消息主体json
                for (String paramName : map.keySet()) {
                    msgtypejsonObject.put(paramName, map.get(paramName));
                }
                //构造消息节点json
                for (int i = 0; i <= list.size() - 1; i++) {
                    secandjsonObject = new JSONObject();
                    for (String paramName : list.get(i).keySet()) {
                        secandjsonObject.put(paramName, list.get(i).get(paramName));
                    }
                    jsonArray.add(secandjsonObject);
                }
                msgtypejsonObject.put("btn", jsonArray);
                firstjsonObject.put("taskcard", msgtypejsonObject);
                break;
        }
        sendTo(agentId, firstjsonObject.toJSONString());
    }

    /**
     * 推送消息
     * @param agentId
     * @param tempdata
     */
    public void sendTo(String agentId, String tempdata) {
        String accessToken = null;
        try {
            accessToken = weixinAccessTokenService.getEnterpriseAccessToken("agentId","");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = URL_PATTERN.replace("{{ACCESS_TOKEN}}", accessToken);
        JSONObject jsonObject = post(url, tempdata);
/*        if (!StringUtils.isEmpty(jsonObject.toJSONString()) && jsonObject.getInteger("errcode") == 0) {
            log.info("消息推送成功");
        } else {
            log.info("消息推送失败 原因：{}", jsonObject.toJSONString());
        }*/
    }

    /**
     * POST请求的RAW参数传递
     *
     * @param url
     * @return
     */
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static JSONObject post(String url, String json) {
        JSONObject jsonObject = null;
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            try (Response response = client.newCall(request).execute()) {
//                json=request.body().string();
                json=request.body().toString();
                jsonObject = JSONObject.parseObject(json);
                return jsonObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}