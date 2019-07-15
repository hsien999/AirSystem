import cn.wyx.entity.Flight;
import cn.wyx.entity.InfoOfFlight;
import cn.wyx.service.ManageFlightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/8 23:16
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestManageFlight {
    @Autowired
    private ManageFlightService manageFlightService;

    @Test
    public void create()
    {
        String flightsId = "MF002";
        Date date = Date.valueOf("2019-07-09");
        Time preUpTime = Time.valueOf("23:22:00");
        Time preDownTime = Time.valueOf("1:20:00");
        this.manageFlightService.CreateFlight(flightsId,date,preUpTime,preDownTime);
    }
    @Test
    public void setflight()
    {
        String flightId = "MF00120190708";
        Time preUpTime = Time.valueOf("1:00:00");
        Time preDownTime = Time.valueOf("2:00:00");
        Time actUpTime = Time.valueOf("3:00:00");
        Time actDownTime = Time.valueOf("4:00:00");
        String flightState = "延误";
        String flightInfo = "暴风雪";
        this.manageFlightService.setFlightPreTime(flightId,preUpTime,preDownTime);
        this.manageFlightService.setFlightActTime(flightId,actUpTime,actDownTime);
        this.manageFlightService.setFlightState(flightId,flightState,flightInfo);
    }
    @Test
    public void findFlightInfo()
    {
        List<InfoOfFlight> infoOfFlightList = this.manageFlightService.findInfoOfFlight("MF00120190708",null,null);
        System.out.println(infoOfFlightList);
    }
}
