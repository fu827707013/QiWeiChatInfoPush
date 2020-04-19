package com.example.demo.pojo;

import lombok.Data;
import java.util.List;

@Data
public class CreateChatGroup {
    private String name;
    private String owner;
    private List<String> userlist;
    private String chatid;
}
