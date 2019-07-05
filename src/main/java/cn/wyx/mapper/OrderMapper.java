package cn.wyx.mapper;

import cn.wyx.entity.InfoOfOrder;
import cn.wyx.entity.Order;
import cn.wyx.entity.UserPass;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/4 20:46
 * @Version 1.0
 */
public interface OrderMapper {
    /**
     * 获取用户的所有订单信息
     * @param userId
     * @return
     */
    List<InfoOfOrder> findAllById(Long userId);

    /**
     * 获取某一订单的信息
     * @param orderId
     * @return
     */
    InfoOfOrder findOneById(String orderId);

    /**
     * 插入订单信息
     * @param order
     * @return
     */
    int insertOrder(Order order);


}
