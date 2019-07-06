package cn.wyx.mapper;

import cn.wyx.entity.Flights;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/6 13:12
 * @Version 1.0
 */
public interface FlightsMapper {
    /**
     * 添加新的航班
     * @param flights
     */
    void create (Flights flights);

    /**
     * 修改航班信息
     * @param flights
     */
    void setFlights (Flights flights);

    /**
     * 根据航班号获取航班信息
     * @param flightsId
     * @return
     */
    Flights findByFlightsId(String flightsId);

    /**
     * 根据航线编号获取航班信息
     * @param airrouteId
     * @return
     */
    List<Flights> findByAirrouteId(Long airrouteId);
}
