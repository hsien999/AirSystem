package cn.wyx.controller;

import cn.wyx.entity.InfoOfFlight;
import cn.wyx.entity.InfoOfTickets;
import cn.wyx.entity.Ticket;
import cn.wyx.entity.Tickets;
import cn.wyx.service.InfoOfFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * @Author: wyx
 * @Date: 2019/7/8 13:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserTicketController {
    @Autowired
    private InfoOfFlightService flightService;

    /**
     * 查询选中的售票信息
     * @param ticketsId
     * @return
     */
    @RequestMapping("/findTicketInfo")
    public InfoOfTickets findTicketsInfo(@RequestParam(value = "ticketsId") String ticketsId) {
        try {
            List<InfoOfTickets> tickets = this.flightService.findInfoOfTickets(ticketsId, null, null);
            if (tickets != null && tickets.size() == 0) {
                return tickets.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查找选中的执飞航班信息
     * @param flightId
     * @return
     */
    @RequestMapping("/findFlightInfo")
    public InfoOfFlight findInfOfFlight(@RequestParam(value = "flightId") String flightId) {
        try {
            List<InfoOfFlight> flight = this.flightService.findFlightByFlightIdFlightsIdDate(flightId, null, null);
            if (flight != null && flight.size() == 0) {
                return flight.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
