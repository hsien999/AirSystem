package cn.wyx.service.impl;

import cn.wyx.entity.InfoOfFlight;
import cn.wyx.entity.InfoOfOldFlight;
import cn.wyx.mapper.InfoOfFlightMapper;
import cn.wyx.mapper.InfoOfOldFlightMapper;
import cn.wyx.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/3 21:27
 * @Version 1.0
 */
@Service
public class InfoServiceIml implements InfoService {

    @Autowired
    private InfoOfFlightMapper infoOfFlightMapper;
    @Autowired
    private InfoOfOldFlightMapper infoOfOldFlightMapper;

    /**
     * 航班订票查询
     * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    @Override
    public List<InfoOfFlight> findFlightByCityDate(String cityStartName, String cityEndName, Date date) {
        return this.infoOfFlightMapper.findByCityDate(cityStartName, cityEndName, date);
    }

    /**
     * 动态航班查询
     * @param cityStartName
     * @param cityEndName
     * @param date
     * @return
     */
    @Override
    public List<InfoOfOldFlight> findOldFlightByCityDate(String cityStartName, String cityEndName, Date date) {
        return this.infoOfOldFlightMapper.findByCityDate(cityStartName,cityEndName,date);
    }
}
