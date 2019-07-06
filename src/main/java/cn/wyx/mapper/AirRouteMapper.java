package cn.wyx.mapper;

import cn.wyx.entity.AirRoute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 23:22
 * @Version 1.0
 */
public interface AirRouteMapper {
    /**
     * 创建新航线
     * @param airRoute
     */
    void create(AirRoute airRoute);

    /**
     * 根据起终点机场查询航线
     * @param airportUpName
     * @param airportDownName
     * @return
     */
    List<AirRoute> findByAirports(@Param("airportUpName") String airportUpName, @Param("airportDownName") String airportDownName);

    /**
     * 根据起终点城市查询航线
     * @param cityStartName
     * @param cityEndName
     * @return
     */
    List<AirRoute> findByCities(@Param("cityStartName") String cityStartName, @Param("cityEndName") String cityEndName);

    /**
     * 设置航线长度
     * @param airportUpName
     * @param airportDownName
     */
    void setLengthByAirports(@Param("airportUpName") String airportUpName, @Param("airportDownName") String airportDownName, @Param("airrouteLength") int airrairrouteLengthoute);
}
