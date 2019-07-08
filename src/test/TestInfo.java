import cn.wyx.entity.*;
import cn.wyx.service.*;
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
    @Autowired
    private InfoOfOldFlightService infoOfOldFlightService;
    @Autowired
    private OrderService orderService;

    @Test
    public void selectFlights()
    {
        String startCityId = "北京";
        String endCityId = "上海";
        Date date = Date.valueOf("2019-1-1");



       //List<InfoOfFlight> infoOfFlights = this.infoOfFlightService.findFlightByCityDate(startCityId,endCityId,date);
//        List<InfoOfFlight> infoOfFlights1 = this.infoOfFlightService.findFlightByFlightIdFlightsIdDate(null,"MF013",date);
//        for (InfoOfFlight o: infoOfFlights1) {
//            System.out.println(o.getFilghtId()+":"+o.getFlightsId());
//            for (InfoOfTickets o2: o.getTickets()) {
//                System.out.println("---- "+ o2);
//            }
//        }
        List<InfoOfTickets> tickets = infoOfFlightService.findInfoOfTickets(null,"1",null);
       System.out.println(tickets);
    }


    @Test
    public void selectOldFlights()
    {
        String startCityId = "北京";
        String endCityId = "上海";
        Date date = Date.valueOf("2019-1-1");

        List<InfoOfOldFlight> infoOfOldFlights = this.infoOfOldFlightService.findOldFlightByCityDate(startCityId,endCityId,date);
       // List<InfoOfOldFlight> infoOfOldFlightList = this.infoOfOldFlightService.findOldFlightByFlightIdFlightsIdDate(null,"MF013",date);
        System.out.println(infoOfOldFlights);
    }

    @Test
    public void selectOrder()
    {
        Long userId = 1L;
        List<InfoOfOrder> infoOfOrders = this.orderService.findAllInfoOfOrderById(userId);
        System.out.println(infoOfOrders);
    }

}
