package cn.wyx.service;

import cn.wyx.entity.InfoOfFlight;
import cn.wyx.entity.InfoOfTickets;

import java.sql.Date;
import java.util.List;


/**
 * @Author: czt
 * @Date: 2019/7/3 21:16
 * @Version 1.0
 * 航班信息查询业务
 */
public interface InfoOfFlightService extends BaseService<InfoOfFlight> {
    /**
     * 航班订票查询
      * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    List<InfoOfFlight> findFlightByCityDate(String cityStartName, String cityEndName, Date date);

    /**
     * 根据 航班编号 或 执飞航班编号 和 日期 获取执飞航班相关信息（输入可为null)
     * @param flightId
     * @param flightsId
     * @param date
     * @return
     */
    List<InfoOfFlight> findFlightByFlightIdFlightsIdDate(String flightId,String flightsId,Date date);
    /**
     * 通过售票Id 或 执飞航班号 或 航舱号 查询所有售票信息
     * @param ticketsId
     * @param flightId
     * @param spaceId
     * @return
     */
    List<InfoOfTickets> findInfoOfTickets(String ticketsId, String flightId, String spaceId);
}
