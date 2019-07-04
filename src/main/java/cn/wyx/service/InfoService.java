package cn.wyx.service;

import cn.wyx.entity.InfoOfFlight;
import cn.wyx.entity.InfoOfOldFlight;
import java.sql.Date;
import java.util.List;


/**
 * @Author: czt
 * @Date: 2019/7/3 21:16
 * @Version 1.0
 * 航班信息查询
 */
public interface InfoService{
    /**
     * 航班订票查询
      * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    List<InfoOfFlight> findFlightByCityDate(String cityStartName, String cityEndName, Date date);

    /**
     * 动态航班查询
     * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    List<InfoOfOldFlight> findOldFlightByCityDate(String cityStartName, String cityEndName, Date date);
}
