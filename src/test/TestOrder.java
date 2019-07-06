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
    }
}
