package cn.wyx.service.impl;

import cn.wyx.entity.InfoOfOldFlight;
import cn.wyx.service.InfoOfOldFlightService;
import cn.wyx.mapper.InfoOfOldFlightMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/4 16:15
 * @Version 1.0
 */
public class InfoOfOldFlightServiceIml implements InfoOfOldFlightService {


    @Autowired
    private InfoOfOldFlightMapper infoOfOldFlightMapper;

    @Override
    public List<InfoOfOldFlight> findAll() {
        return null;
    }

    @Override
    public InfoOfOldFlight findById(Long id) {
        return null;
    }

    @Override
    public InfoOfOldFlight findById(String id) {
        return null;
    }

    @Override
    public void create(InfoOfOldFlight infoOfOldFlight) {

    }

    @Override
    public void update(InfoOfOldFlight infoOfOldFlight) {

    }

    @Override
    public void delete(Long... ids) {

    }

    @Override
    public void delete(String... ids) {

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
