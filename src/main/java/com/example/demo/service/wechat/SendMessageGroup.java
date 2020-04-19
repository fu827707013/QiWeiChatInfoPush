package com.example.demo.service.wechat;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.CreateChatGroup;
import com.example.demo.pojo.markdownModel;
import com.example.demo.utils.MapInitializer;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SendMessageGroup {
    WeixinMessageGroupService wexin = new WeixinMessageGroupService();
    final String agentId = "1000000";
    final String touser = "Win";
    final String toparty = "";
    final String totag = "";
    final String sendUrl = " https://qyapi.weixin.qq.com/cgi-bin/appchat/send?access_token=%s";

    public void SendMessageText() {
        //文本消息
        try {
            wexin.send(WxTempConstant.TEMP_TEXT, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("content", "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SendMessageImage() {
        //图片消息
        try {
            wexin.send(WxTempConstant.TEMP_IMAGE, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("media_id", "MEDIA_ID");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SendMessageVoice() {
        //语音消息
        try {
            wexin.send(WxTempConstant.TEMP_VOICE, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("media_id", "MEDIA_ID");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SendMessageVideo() {
        //视频消息
        try {
            wexin.send(WxTempConstant.TEMP_VIDEO, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("media_id", "MEDIA_ID");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SendMessageFile() {
        //文件消息
        try {
            wexin.send(WxTempConstant.TEMP_FILE, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("media_id", "MEDIA_ID");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SendMessageTextCard() {
        //文本卡片消息
        try {
            wexin.send(WxTempConstant.TEMP_TEXT_CARD, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("title", "领奖通知");
                            m.put("description", "<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>");
                            m.put("url", "URL");
                            m.put("btntxt", "更多");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SendMessageNews() {
        //图文消息
        try {
            wexin.send(WxTempConstant.TEMP_NEWS, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                            Map<String, String> m1 = new HashMap<>();
                            m1.put("title", "中秋节礼品领取1");
                            m1.put("description", "今年中秋节公司有豪礼相送");
                            m1.put("url", "http://www.baidu.com");
                            m1.put("picurl", "http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png");
                            m.add(m1);

                            Map<String, String> m2 = new HashMap<>();
                            m2.put("title", "中秋节礼品领取2");
                            m2.put("description", "今年中秋节公司有豪礼相送");
                            m2.put("url", "http://www.baidu.com");
                            m2.put("picurl", "http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png");
                            m.add(m2);
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void SendMessageMpnews() {
        //图文消息（mpnews）
        try {
            wexin.send(WxTempConstant.TEMP_MPNEWS, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                            Map<String, String> m1 = new HashMap<>();
                            m1.put("title", "Title");
                            m1.put("thumb_media_id", "MEDIA_ID");
                            m1.put("author", "Author");
                            m1.put("content_source_url", "URL");
                            m1.put("content", "content");
                            m1.put("digest", "Digest description");
                            m.add(m1);

                            Map<String, String> m2 = new HashMap<>();
                            m2.put("title", "Title");
                            m2.put("thumb_media_id", "MEDIA_ID");
                            m2.put("author", "Author");
                            m2.put("content_source_url", "URL");
                            m2.put("content", "content");
                            m2.put("digest", "Digest description");
                            m.add(m2);
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public String SendMessageMarkdown(String access_token, String type, markdownModel model) {
        //markdown消息
        String json ="";
        try {
            markdownModel.markdown ch = new markdownModel.markdown();
            ch.content = getContent(type);// 获取模板类型
            model.markdown = ch;

            OkHttpClient client = new OkHttpClient();
             json = JSONObject.toJSONString(model);

            RequestBody body = RequestBody.create(json, JSON);
            Request request = new Request.Builder()
                    .url(String.format(sendUrl, access_token))
                    .post(body)
                    .build();
            try {
                try (Response response = client.newCall(request).execute()) {
                    json = response.body().string();
//                jsonObject = JSONObject.parseObject(json);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
        return json;
    }

    public void SendMessageMiniprogeamNotice() {
        //小程序通知消息
        try {
            wexin.send(WxTempConstant.TEMP_MINIPROGEAM_NOTICE, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("appid", "appid");
                            m.put("page", "pages/index?userid=zhangsan&orderid=123123123");
                            m.put("title", "会议室预订成功通知");
                            m.put("description", "appid");
                            m.put("emphasis_first_item", "true");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                            Map<String, String> m1 = new HashMap<>();
                            m1.put("key", "会议室");
                            m1.put("value", "402");
                            m.add(m1);

                            Map<String, String> m2 = new HashMap<>();
                            m2.put("key", "会议室1");
                            m2.put("value", "403");
                            m.add(m2);
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void SendMessageTaskCard() {
        //任务卡片消息
        try {
            wexin.send(WxTempConstant.TEMP_TASK_CARD, touser, toparty, totag,
                    new MapInitializer<String, String>() {
                        @Override
                        public void init(Map<String, String> m) {
                            m.put("appid", "appid");
                            m.put("page", "pages/index?userid=zhangsan&orderid=123123123");
                            m.put("title", "会议室预订成功通知");
                            m.put("description", "appid");
                            m.put("emphasis_first_item", "true");
                        }

                        @Override
                        public void initListMap(List<Map<String, String>> m) {
                            Map<String, String> m1 = new HashMap<>();
                            m1.put("key", "会议室");
                            m1.put("value", "402");
                            m.add(m1);

                            Map<String, String> m2 = new HashMap<>();
                            m2.put("key", "会议室1");
                            m2.put("value", "403");
                            m.add(m2);
                        }
                    }, agentId);
        } catch (Exception e) {
//            log.error("发送模板消息失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getContent(String type) {
        String content = "";
        switch (type) {
            case "1":
                content = markdownContent;
                break; //可选
            case "2":
                break; //可选
            //你可以有任意数量的case语句
            default: //可选
                //语句
        }
        return content;
    }

    final String markdownContent = "`Michael的博客已更新`\n" +
            ">**标题**\n" +
            ">描　述：<font color=\"info\">敬请期待</font>\n" +
            ">\n" +
            ">日　期：<font color=\\\"warning\\\">2018年5月18日</font>\n" +
            ">时　间：<font color=\\\"comment\\\">上午9:00-11:00</font>\n" +
            ">\n" +
            ">详细内容，请点击：[Michael`s blog](https://work.weixin.qq.com)";
}