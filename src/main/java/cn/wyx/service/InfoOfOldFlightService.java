package cn.wyx.service;

import cn.wyx.entity.InfoOfOldFlight;

import java.sql.Date;
import java.util.List;

/**
 * 动态航班查询业务
 * @Author: czt
 * @Date: 2019/7/4 16:12
 * @Version 1.0
 */
public interface InfoOfOldFlightService extends BaseService<InfoOfOldFlight> {

    /**
     * 动态航班查询
     * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    List<InfoOfOldFlight> findOldFlightByCityDate(String cityStartName, String cityEndName, Date date);
}
