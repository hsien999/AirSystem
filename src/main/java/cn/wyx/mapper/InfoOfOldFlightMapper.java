package cn.wyx.mapper;

import cn.wyx.entity.InfoOfOldFlight;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/3 19:56
 * @Version 1.0
 */
public interface InfoOfOldFlightMapper {
    /**
     * 查询动态航班结果
     * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    List<InfoOfOldFlight> findByCityDate(@Param("cityStartName") String cityStartName, @Param("cityEndName") String cityEndName, @Param("date") Date date);
}
