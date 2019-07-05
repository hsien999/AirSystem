package cn.wyx.mapper;

import cn.wyx.entity.Passenger;

/**
 * @Author: czt
 * @Date: 2019/7/5 15:27
 * @Version 1.0
 */
public interface PassengerMapper {
    /**
     * 插入乘客信息
     * @param passenger
     * @return
     */
    int insertPassenger(Passenger passenger);
}
