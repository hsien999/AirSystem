import cn.wyx.entity.InfoOfOldFlight;
import cn.wyx.entity.InfoOfTickets;
import cn.wyx.service.InfoOfFlightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

import cn.wyx.entity.InfoOfFlight;
/**
 * @Author: czt
 * @Date: 2019/7/3 21:37
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestInfo {

    @Autowired
    private InfoOfFlightService infoOfFlightService;

    @Test
    public void select()
    {
        String startCityId = "北京";
        String endCityId = "上海";
        Date date = Date.valueOf("2019-1-1");


       List<InfoOfFlight> infoOfFlights = this.infoOfFlightService.findFlightByCityDate(startCityId,endCityId,date);
        for (InfoOfFlight o: infoOfFlights) {
            System.out.println(o.getFilghtId()+":"+o.getFlightsId());
            for (InfoOfTickets o2: o.getTickets()) {
                System.out.println("---- "+ o2);
            }
        }
       //System.out.println(infoOfFlights);
    }


    @Test
    public void selectOld()
    {
        String startCityId = "北京";
        String endCityId = "上海";
        Date date = Date.valueOf("2019-1-1");

        List<InfoOfOldFlight> infoOfOldFlights = this.infoOfFlightService.findOldFlightByCityDate(startCityId,endCityId,date);
        System.out.println(infoOfOldFlights);
    }

}
