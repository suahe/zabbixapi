package com.cn.scott.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZabbixConfig
 * @Author YanZhen
 * @Date 2021/7/12
 * @Version V1.0
 **/
@Component
@ConfigurationProperties(prefix = "zabbix.config")
@Data
public class ZabbixConfig {

    private String url;
    private String username;
    private String password;
}
