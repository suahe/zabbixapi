package com.cn.scott.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.hengyunabc.zabbix.api.Request;
import io.github.hengyunabc.zabbix.api.ZabbixApi;

import static org.apache.logging.log4j.util.Strings.isBlank;

/**
 * @ClassName AbstractZabbixService
 * @Author YanZhen
 * @Date 2021/7/13
 * @Version V1.0
 **/
public abstract class AbstractZabbixService {


    protected JSONObject zabbixRequest(ZabbixApi zabbixApi,Request request) throws Exception {
        JSONObject response = zabbixApi.call(request);
        return response;
    }

    protected void zabbixError(JSONObject response) throws Exception {
        if (!isBlank(response.getString("error")))
            throw new Exception("向Zabbix请求出错了！" + JSON.parseObject(response.getString("error")).getString("data"));
    }

}
