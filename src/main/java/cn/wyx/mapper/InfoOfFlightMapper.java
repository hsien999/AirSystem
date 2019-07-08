package cn.wyx.mapper;
import cn.wyx.entity.InfoOfFlight;
import org.apache.ibatis.annotations.Param;
import java.sql.Date;
import java.util.List;

public interface InfoOfFlightMapper {
    /**
     * 查询航班机票结果
     * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    List<InfoOfFlight> findByCityDate(@Param("cityStartName") String cityStartName, @Param("cityEndName") String cityEndName, @Param("date") Date date);

    List<InfoOfFlight> findByFlightIdFlightsId(@Param("flightId") String flightId,@Param("flightsId") String flightsId ,@Param("date") Date date);
}
