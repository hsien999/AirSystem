package cn.wyx.mapper;

import cn.wyx.entity.InfoOfFlight;
import cn.wyx.entity.InfoOfFlights;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/8 12:31
 * @Version 1.0
 */
public interface InfoOfFlightsMapper {
    /**
     * 查询航班
     * @param flightsId
     * @param airportUpName
     * @param airportDownName
     * @return
     */
    List<InfoOfFlights> findFlights(@Param("flightsId") String flightsId,@Param("airportUpName") String airportUpName,@Param("airportDownName") String airportDownName);


}
