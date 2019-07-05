package cn.wyx.service;

import cn.wyx.entity.InfoOfOrder;
import cn.wyx.entity.Order;
import cn.wyx.entity.Passenger;
import cn.wyx.entity.Ticket;

import java.util.List;

/**
 * 获取查看订单的信息
 * @Author: czt
 * @Date: 2019/7/4 21:46
 * @Version 1.0
 */
public interface OrderService extends BaseService<InfoOfOrder>{

    /**
     * 通过用户Id查找用户所有订单信息
     * @param userId
     * @return
     */
     List<InfoOfOrder> findAllInfoOfOrderById(Long userId);

    /**
     * 创建新的订单
     * @param order
     * @param ticketsId
     * @param passengerList
     */
     void createNewOrder(Order order,String ticketsId, List<Passenger> passengerList);
}
