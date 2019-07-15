package cn.wyx.controller;

import cn.wyx.entity.*;
import cn.wyx.service.InfoOfFlightService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wyx
 * @Date: 2019/7/8 13:39
 * @Version 1.0
 */
@RestController
public class OrderTicketController {
    @Autowired
    private InfoOfFlightService flightService;

    /**
     * 校验
     */
    @RequestMapping("/orderTicket")
    public Result orderTicket(@RequestParam(value = "stCity") String stCity,
                              @RequestParam(value = "edCity") String edCity,
                              @RequestParam(value = "searchDate") String searchDate,
                              @RequestParam(value = "flightId") String flightId,
                              @RequestParam(value = "ticketsId") String ticketsId) {
        Subject subject = SecurityUtils.getSubject();
        String msg = "login.html";
        boolean success = false;
        try {
            //已经登录或通过rememberMe
            if (subject != null && (subject.isAuthenticated() || subject.isRemembered())) {
                msg = "user/orderNav1.html?" + "&flightId=" + flightId + "&ticketsId=" + ticketsId;
                success = true;
            } else {
                msg = "redUrl=user/orderNav0.html?stCity=" + stCity + "&edCity" + edCity + "&searchDate=" + searchDate;
                success = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(success, msg);
    }

    /**
     * 查询选中的售票信息
     *
     * @param ticketsId
     * @return
     */
    @RequestMapping("/findTicketsInfo")
    public InfoOfTickets findTicketsInfo(@RequestParam(value = "ticketsId") String ticketsId) {
        try {
            List<InfoOfTickets> tickets = this.flightService.findInfoOfTickets(ticketsId, null, null);
            if (tickets != null && tickets.size() > 0) {
                InfoOfTickets ticket = tickets.get(0);
                return ticket;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查找选中的执飞航班信息
     *
     * @param flightId
     * @return
     */
    @RequestMapping("/findFlightInfo")
    public InfoOfFlight findInfOfFlight(@RequestParam(value = "flightId") String flightId) {
        try {
            List<InfoOfFlight> flight = this.flightService.findFlightByFlightIdFlightsIdDate(flightId, null, null);
            if (flight != null && flight.size() > 0) {
                InfoOfFlight infoOfFlight = flight.get(0);
                return infoOfFlight;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
