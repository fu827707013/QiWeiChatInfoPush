package com.example.demo.controllers;

import com.example.demo.pojo.markdownModel;
import com.example.demo.service.wechat.CeateWeChat;
import com.example.demo.service.wechat.SendMessage;
import com.example.demo.service.wechat.SendMessageGroup;
import com.example.demo.service.wechat.WeixinAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SendMessageController {

    @Autowired
    private WeixinAccessTokenService meixinAccessTokenService;

    @GetMapping("/WXGetToken/{corpid}")
    public String WXGetToken(@PathVariable(name = "corpid") String corpid, @RequestParam(name = "corpsecret") String corpsecret) {
        String res="";
        try {
            res= meixinAccessTokenService.getEnterpriseAccessToken(corpid, corpsecret);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Autowired
    private CeateWeChat ceateWeChat;

    @GetMapping("/CeateWeChat/{agentId}")
    public String CeateWeChat(@PathVariable(name = "agentId") String agentId, @RequestParam(name = "name") String name
            , @RequestParam(name = "chatid") String chatid, @RequestParam(name = "access_token") String access_token) {
        if (name.length() == 0)
            name = "消息推送测试群";
        return ceateWeChat.CeateWeChatpost(access_token, name, chatid);
    }

    @Autowired
    private SendMessageGroup sendMessageGroup;

    @GetMapping("/SendMessageGroup/{type}")
    public String SendMessageGroup(@PathVariable(name = "type") String type
            , @RequestParam(name = "chatid") String chatid, @RequestParam(name = "access_token") String access_token) {
        String msgtype = "markdown";
        markdownModel model = new markdownModel();
        model.chatid = chatid;
        model.msgtype = msgtype;
        return sendMessageGroup.SendMessageMarkdown(access_token, type, model);
    }

    @Autowired
    private SendMessage sendMessage;

    @GetMapping("/SendMessage")
    public String SendMessage() {
        final String agentId = "100000";
        final String touser = "Win";
        final String toparty = "";
        final String totag = "";
        sendMessage.SendMessageMarkdown();
        return "";
    }
}