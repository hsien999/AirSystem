package cn.wyx.service;

import cn.wyx.entity.Airport;
import cn.wyx.entity.City;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/6 22:47
 * @Version 1.0
 */
public interface CityAirportService {
    /**
     * 创建新城市
     * @param cityName
     * @param cityAlp
     */
    void createCity(String cityName, String cityAlp);
    /**
     * 获取城市编号
     * @param cityName
     * @return
     */
    City getCityByName(String cityName);
    /**
     * 设置城市信息
     * @param city
     */
    void setCity(City city);

    /**
     * 添加新的机场
     * @param cityName
     * @param airportName
     */
    void createAirport(String cityName, String airportName);

    /**
     * 修改机场信息
     * @param airport
     */
    void setAirport(Airport airport);

    /**
     * 根据城市名查询城市
     * @param cityName
     * @return
     */
    List<Airport> findAirportByCityName(String cityName);

    /**
     * 根据机场名获取机场对象
     * @param airportName
     * @return
     */
    Airport findAirportByAirportName(String airportName);
}
