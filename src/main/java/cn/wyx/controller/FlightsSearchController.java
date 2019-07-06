package cn.wyx.controller;

import cn.wyx.entity.InfoOfFlight;
import cn.wyx.service.InfoOfFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * @Author: wyx
 * @Date: 2019/7/5 17:01
 * @Version 1.0
 */
@RestController
public class FlightsSearchController {

    @Autowired
    private InfoOfFlightService flightService;

    @RequestMapping("/findAllInfoOfFlights")
    public List<InfoOfFlight> findAllInfoOfFlights(@RequestParam(value = "stCity") String stCity, @RequestParam(value = "edCity") String edCity, @RequestParam(value = "searchDate") Date searchDate) {

        try {
            System.out.println(this.flightService.findFlightByCityDate(stCity, edCity, searchDate));
            return this.flightService.findFlightByCityDate(stCity, edCity, searchDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
