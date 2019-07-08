package cn.wyx.service.impl;

import cn.wyx.entity.Airport;
import cn.wyx.entity.City;
import cn.wyx.mapper.AirportMapper;
import cn.wyx.mapper.CityMapper;
import cn.wyx.service.CityAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/6 23:00
 * @Version 1.0
 */
@Service
public class CityAirportServiceIml implements CityAirportService {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AirportMapper airportMapper;


    @Override
    public void createCity(String cityName, String cityAlp) {
        City city = this.cityMapper.getCityIdByName(cityName);
        if(city == null)
            this.cityMapper.create(cityName,cityAlp);
    }

    @Override
    public City getCityByName(String cityName) {
        return this.cityMapper.getCityIdByName(cityName);
    }

    @Override
    public void setCity(City city) {
        this.cityMapper.setCity(city);
    }

    @Override
    public void createAirport(String cityName, String airportName) {
        City city = this.cityMapper.getCityIdByName(cityName);
        Airport airport = this.airportMapper.findAirportByAirportName(airportName);
        if(airport == null)
            this.airportMapper.create(city.getCityId(),airportName);
    }

    @Override
    public void setAirport(Airport airport) {
        this.airportMapper.setAirport(airport);
    }

    @Override
    public List<Airport> findAirportByCityName(String cityName) {
        return this.airportMapper.findAirportByCityName(cityName);
    }

    @Override
    public Airport findAirportByAirportName(String airportName) {
        return this.airportMapper.findAirportByAirportName(airportName);
    }
}
