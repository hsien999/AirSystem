import cn.wyx.entity.Order;
import cn.wyx.entity.Passenger;
import cn.wyx.entity.Ticket;
import cn.wyx.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 15:04
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestOrder {
    @Autowired
    private OrderService orderService;

    @Test
    public void createOrder()
    {
        Order order = new Order(null,1L,200, Timestamp.valueOf("2020-01-01 13:45:06.8"),null,"支付宝",2,"未支付","小明", "110","110@qq.com");
        String ticketsId = "TK1";
        List<Passenger> passengers = new ArrayList<>();
        Passenger passenger1 = new Passenger(0L,null,"沈耀","台湾居住证","123456","18101010101","儿童");
        passengers.add(passenger1);
        passenger1 = new Passenger(0L,null,"小米","身份","18106932995","18101010101","成人");
        passengers.add(passenger1);
        orderService.createNewOrder(order,ticketsId,passengers);
    }
}
