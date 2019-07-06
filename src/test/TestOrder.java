import cn.wyx.entity.Order;
import cn.wyx.entity.Ticket;
import cn.wyx.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        Order order = new Order("o3",2L,200,null,null,"支付宝",2,"未支付","小明", "110","110@qq.com");
        List<Ticket> ticketList = new ArrayList<Ticket>();
        Ticket ticket = new Ticket("ticket55","TK1",null,100,50,20,30);
        ticketList.add(ticket);
        ticket = new Ticket("ticket56","TK1",null,100,50,20,31);
        ticketList.add(ticket);
//        orderService.createNewOrder(order,ticketList);
    }
}
