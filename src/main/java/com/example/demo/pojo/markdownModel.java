package com.example.demo.pojo;

import lombok.Data;

@Data
public class markdownModel {
    public String chatid;
    public String msgtype;
    public markdown markdown;

    public static class markdown {
        public String content;
    }
}


