package cn.wyx.service.impl;

import cn.wyx.entity.InfoOfFlight;
import cn.wyx.entity.InfoOfOldFlight;
import cn.wyx.mapper.InfoOfFlightMapper;
import cn.wyx.mapper.InfoOfOldFlightMapper;
import cn.wyx.service.InfoOfFlightService;
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
public class InfoOfFlightServiceIml implements InfoOfFlightService {

    @Autowired
    private InfoOfFlightMapper infoOfFlightMapper;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public InfoOfFlight findById(Long id) {
        return null;
    }

    @Override
    public InfoOfFlight findById(String id) {
        return null;
    }

    @Override
    public void create(InfoOfFlight infoOfFlight) {

    }

    @Override
    public void update(InfoOfFlight infoOfFlight) {

    }

    @Override
    public void delete(Long... ids) {

    }

    @Override
    public void delete(String... ids) {

    }

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


}
