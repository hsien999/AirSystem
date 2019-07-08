package cn.wyx.service;

import cn.wyx.entity.AirRoute;
import cn.wyx.entity.InfoOfFlights;

import java.sql.Time;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/7 20:14
 * @Version 1.0
 */
public interface ManageFlightsService {

    /**
     * 添加新航线
     * @param airportUpName
     * @param airportDownName
     * @param length
     */
    void createAirRoute(String airportUpName,String airportDownName,int length);

    /**
     * 通过城市名查找航线
     * @param startCityName
     * @param endCityName
     * @return
     */
    List<AirRoute>  findAirRouteByCitiesName(String startCityName,String endCityName);

    /**
     * 通过机场名查找航线
     * @param airportUpName
     * @param airportDownName
     * @return
     */
    AirRoute findAirRouteByAirportsName(String airportUpName,String airportDownName);

    /**
     * 修改航线长度
     * @param airportUpName
     * @param airportDownName
     * @param length
     */
    void setLengthByAirportsName(String airportUpName,String airportDownName,int length);

    /**
     * 根据机型和航线长度计算飞行时间(分钟）
     * @param modelId
     * @param length
     */
    int calculatePlanTime(Long modelId,int length);

    /**
     * 根据计划到达时间和飞行时间计算计划到达时间
     * @param planUpTime
     * @param planTime
     * @return
     */
    Time calculatePlanDownTime(Time planUpTime,int planTime);

    /**
     * 插入航班
     * @param infoOfFlights
     */
    void createFlights(InfoOfFlights infoOfFlights);

    /**
     * 修改航班
     * @param infoOfFlights
     */
    void setFlights(InfoOfFlights infoOfFlights);

    /**
     * 查询航班(输入值可以为null)
     * @param flightsId
     * @param airportUpName
     * @param airportDownName
     */
    List<InfoOfFlights> findFlights(String flightsId,String airportUpName,String airportDownName);

}
