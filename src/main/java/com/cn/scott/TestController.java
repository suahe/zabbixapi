package com.cn.scott;

import com.cn.scott.service.ZabbixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Author: cqt123456789
 * @CreateTime: 2022-12-05 14:37
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private ZabbixService zabbixService;

    @RequestMapping("/getHostList")
    public String getHostList() throws Exception {
        return zabbixService.getHostList();
    }

    @RequestMapping("/getMonitorItems/{hostId}")
    public String getMonitorItems(@PathVariable("hostId") String hostId) throws Exception {
        return zabbixService.getMonitorItems(hostId);
    }
}