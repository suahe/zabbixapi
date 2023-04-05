package com.cn.scott.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.scott.utils.ZabbixUtil;
import io.github.hengyunabc.zabbix.api.Request;
import io.github.hengyunabc.zabbix.api.RequestBuilder;
import io.github.hengyunabc.zabbix.api.ZabbixApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ZabbixService
 * @Author YanZhen
 * @Date 2021/7/13
 * @Version V1.0
 **/
@Service
public class ZabbixService  extends AbstractZabbixService{

    @Autowired
    private ZabbixUtil zabbixUtil;

    //获取主机列表
    public String getHostList() throws Exception {
        ZabbixApi zabbixApi = zabbixUtil.getZabbixApi();
        Request request = RequestBuilder.newBuilder().method("host.get")
                .paramEntry("output", new String[]{"host", "name", "description", "hostid"})
                .paramEntry("selectGroups", "extend")
                .build();
        JSONObject response = zabbixRequest(zabbixApi,request);
        zabbixError(response);
        JSONArray result = response.getJSONArray("result");
        return result.toJSONString();
    }

    //获取监控项
    public String getMonitorItems(String hostId) throws Exception {
        ZabbixApi zabbixApi = zabbixUtil.getZabbixApi();
        Request request = RequestBuilder.newBuilder().method("item.get")
                .paramEntry("output","extend").paramEntry("hostids",hostId).build();
        JSONObject response = zabbixRequest(zabbixApi,request);
        zabbixError(response);
        JSONArray result = response.getJSONArray("result");
        return result.toJSONString();
    }


}
