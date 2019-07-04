import cn.wyx.service.InfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.lang.Long;
import java.sql.Date;

/**
 * @Author: czt
 * @Date: 2019/7/3 21:37
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestInfo {

    @Autowired
    private InfoService infoService;

    @Test
    public void select()
    {
        Long startCityId = 1L;
        Long endCityId = 2L;
        Date date = new Date(20170201);
        System.out.println(date);
       //List<InfoOfFlight> infoOfFlights = this.infoService.findFlightByCityDate(startCityId)
    }
}
