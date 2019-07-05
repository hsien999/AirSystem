package cn.wyx.service.impl;

import cn.wyx.entity.InfoOfOrder;
import cn.wyx.entity.Order;
import cn.wyx.entity.Passenger;
import cn.wyx.entity.Ticket;
import cn.wyx.mapper.OrderMapper;
import cn.wyx.mapper.PassengerMapper;
import cn.wyx.mapper.TicketMapper;
import cn.wyx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/4 21:51
 * @Version 1.0
 */
@Service
public class OrderServiceIml implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private PassengerMapper passengerMapper;


    @Override
    public void createNewOrder(Order order,String ticketsId,List<Passenger>passengerList) {
        //订单数据处理
//
//        order.setOrderId("OD"+order.getOrderSureTime().);
//        this.orderMapper.insertOrder(order);
//        Order
//        for (Ticket tk:ticketList ) {
//            tk.setOrderId(order.getOrderId());
//            this.ticketMapper.insertTicket(tk);
//        }
    }

    /**
     * 查询一个用户的所有用户信息
     * @param userId
     * @return
     */
    @Override
    public List<InfoOfOrder> findAllInfoOfOrderById(Long userId) {
        return orderMapper.findAllById(userId);
    }


    @Override
    public List<InfoOfOrder> findAll() {
        return null;
    }

    @Override
    public InfoOfOrder findById(Long id) {
        return null;
    }

    /**
     * 通过orderId查询一个订单的信息
     * @param id
     * @return
     */
    @Override
    public InfoOfOrder findById(String id) {
        return orderMapper.findOneById(id);
    }

    @Override
    public void create(InfoOfOrder infoOfOrder) {

    }

    @Override
    public void update(InfoOfOrder infoOfOrder) {

    }

    @Override
    public void delete(Long... ids) {

    }

    @Override
    public void delete(String... ids) {

    }

    public String dateTimeToString(Timestamp time){
        String ss = time.toString();
        String sb1 = ss.substring(0,3),sb2 = ss.substring(5,6),sb3 = ss.substring(8,9);
        String sb4 = ss.substring(11,12),sb5 = ss.substring(14,15),sb6 = ss.substring(17,18);
        String result = sb1+sb2+sb3+sb4+sb5+sb6;
        return result;
    }
}
