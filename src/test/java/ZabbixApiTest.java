import com.cn.scott.ZabbixApiDemoApplication;
import com.cn.scott.service.ZabbixService;
import com.cn.scott.utils.ZabbixUtil;
import io.github.hengyunabc.zabbix.api.ZabbixApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName ZabbixApiTest
 * @Author YanZhen
 * @Date 2021/7/13
 * @Version V1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZabbixApiDemoApplication.class)
public class ZabbixApiTest {

    @Autowired
    private ZabbixService zabbixService;


    @Test
    public void getHostList() throws Exception {
        String hostList = zabbixService.getHostList();
        System.out.println(hostList);

    }

    @Test
    public void getMonitorItems() throws Exception {
        String monitorItems = zabbixService.getMonitorItems("10084");
        System.out.println(monitorItems);
    }
}
