package cn.wyx.mapper;

import cn.wyx.entity.Flight;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/8 19:36
 * @Version 1.0
 */
public interface FlightMapper {

    /**
     * 创建执飞航班
     * @param flight
     */
    void create(Flight flight);

    /**
     * 设置执飞航班
     * @param flight
     */
    void setFlight(Flight flight);

    /**
     * 通过 执飞航班编号 航班号 执飞航班状态 或 日期查找执飞航班（都可为null)
     * @param flightId
     * @param flightsId
     * @param flightState
     * @param date
     * @return
     */
    List<Flight> findFlightByIdDateState(@Param("flightId") String flightId, @Param("flightsId") String flightsId, @Param("flightState") String flightState, @Param("date") Date date);

    /**
     * 通过日期范围 和 执飞航班状态 查询执飞航班 （都可为null)
     * @param dateLeft
     * @param dateRight
     * @param flightState
     * @return
     */
    List<Flight> flndFlightByDateRangeAndState(@Param("dateLeft") Date dateLeft, @Param("dateRight") Date dateRight, @Param("flightState") String flightState);

}
