package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.ResultMsg;
import com.example.demo.utils.AppStatusCode;

public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {
    protected ResultMsg createResultMsg(Object data) {
        ResultMsg result = new ResultMsg();
        return result.createResultMsg(data);
    }

    protected ResultMsg createResultMsg() {
        ResultMsg result = new ResultMsg();
        return result.createResultMsg(null);
    }

    protected ResultMsg createErrorMsg(AppStatusCode statusCode) {
        ResultMsg result = new ResultMsg();
        return result.createErrorMsg(statusCode);
    }
}
