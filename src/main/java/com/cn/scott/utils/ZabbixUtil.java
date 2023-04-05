package com.cn.scott.utils;

import com.cn.scott.config.ZabbixConfig;
import io.github.hengyunabc.zabbix.api.DefaultZabbixApi;
import io.github.hengyunabc.zabbix.api.ZabbixApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZabbixUtil
 * @Author YanZhen
 * @Date 2021/7/12
 * @Version V1.0
 **/


@Component
@Slf4j
public class ZabbixUtil {

    private volatile ZabbixApi zabbixApi;

    @Autowired
    private ZabbixConfig zabbixConfig;


    public ZabbixApi getZabbixApi() {
        if (null == zabbixApi) {
            synchronized (ZabbixUtil.class) {
                if (null == zabbixApi) {
                    zabbixApi = new DefaultZabbixApi(zabbixConfig.getUrl());
                    zabbixApi.init();
                    login();
                }
            }
        }
        return zabbixApi;
    }

    private void login(){
        boolean login = zabbixApi.login(zabbixConfig.getUsername(), zabbixConfig.getPassword());
        if(!login){
            throw new RuntimeException("zabbix login failed!");
        }
        log.info("zabbix login success!");
    }

}
