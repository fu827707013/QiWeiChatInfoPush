package com.example.demo.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import com.example.demo.utils.AppStatusCode;

@Data
public class ResultMsg {
    private Boolean Success;
    private Integer Code;
    private String Message;
    private Object Data;

    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(this.Data);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultMsg createResultMsg (Object data) {
        AppStatusCode statusCode = AppStatusCode.Ok;
        ResultMsg result = new ResultMsg();
    /*    result.setSuccess(true);
        result.setMessage(statusCode.getValue());
        result.setCode(statusCode.getCode());
        result.setData(data);*/
        return result;
    }

    public ResultMsg createErrorMsg(AppStatusCode statusCode){
        ResultMsg result = new ResultMsg();
    /*    result.setSuccess(false);
        result.setMessage(statusCode.getValue());
        result.setCode(statusCode.getCode());*/
        return result;
    }

    public ResultMsg createErrorMsg(AppStatusCode statusCode, String msg){
        ResultMsg result = new ResultMsg();
   /*     result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(statusCode.getCode());*/
        return result;
    }
}