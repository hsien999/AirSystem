package cn.wyx.service;

import cn.wyx.entity.InfoOfFlight;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/8 21:11
 * @Version 1.0
 */
public interface ManageFlightService {

    /**
     * 建立执飞航班(会自动建立该航班的售票)
     * @param flightsId
     * @param flightDate
     * @param preUpTime
     * @param preDownTime
     */
    void CreateFlight(String flightsId, Date flightDate, Time preUpTime,Time preDownTime);

    /**
     * 设置预计起降时间
     * @param flightId
     * @param preUpTime
     * @param preDownTime
     */
    void setFlightPreTime(String flightId,Time preUpTime,Time preDownTime);

    /**
     * 设置实际起降时间
     * @param flightId
     * @param actUpTime
     * @param actDownTime
     */
    void setFlightActTime(String flightId,Time actUpTime,Time actDownTime);

    /**
     * 设置飞机状态和说明
     * @param flightId
     * @param flightState
     * @param flightInfo
     */
    void setFlightState(String flightId,String flightState,String flightInfo);
    /**
    * 根据 航班编号 或 执飞航班编号 和 日期 获取执飞航班相关信息（输入可为null)
    * @param flightId
     * @param flightsId
     * @param date
     * @return
     */
    List<InfoOfFlight> findInfoOfFlight(String flightId,String flightsId,Date date);
}
