package cn.wyx.mapper;

import cn.wyx.entity.Airport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 22:49
 * @Version 1.0
 */
public interface AirportMapper {
    /**
     * 添加新的机场
     * @param cityId
     * @param airportName
     */
    void create(@Param("cityId") Long cityId, @Param("airportName") String airportName);

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
