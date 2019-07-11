package cn.wyx.service.impl;

import cn.wyx.entity.*;
import cn.wyx.mapper.*;
import cn.wyx.service.ManageFlightService;
import cn.wyx.service.ModelSpaceRuleService;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/8 21:40
 * @Version 1.0
 */
@Service
public class ManageFlightServiceIml implements ManageFlightService {
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private SpaceMapper spaceMapper;
    @Autowired
    private MdspMapper mdspMapper;
    @Autowired
    private FlightsMapper flightsMapper;
    @Autowired
    private InfoOfFlightMapper infoOfFlightMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AirRouteMapper airRouteMapper;
    @Autowired
    private TicketsMapper ticketsMapper;

    @Override
    public void CreateFlight(String flightsId, Date flightDate, Time preUpTime, Time preDownTime) {
        //合成执飞航班编号
        String dateStrnig = dateToString(flightDate);
        String flightId = flightsId + dateStrnig;
        //插入相关信息
        String flightState = "计划中";
        String flightInfo = null;
        Time actUpTime = null;
        Time actDownTime = null;
        Flight flight = new Flight(flightId,flightsId,flightDate,flightState,flightInfo,preUpTime,preDownTime,actUpTime,actDownTime);
        this.flightMapper.create(flight);

        //自动生成所有售票

        //获取该机型的所有舱型，以便给每个舱型建立售票
        Flights flights = this.flightsMapper.findByFlightsId(flightsId);
        List<Mdsp> mdspList = this.mdspMapper.findMdsp(flights.getModelId(),null);
        //获取航线距离
        AirRoute airRoute = this.airRouteMapper.findById(flights.getAirrouteId());
        int length = airRoute.getAirrouteLength();
        //计算标准票价
        int baseTicketsPrice = calculateBasePrece(length);

        Space space = null;
        int ticketsPrice = 0;
        int nums = 0;
        Tickets tickets = null;
        String ticketsId = null;
        for(int i = 0; i < mdspList.size();i++)
        {
            space = this.spaceMapper.findById(mdspList.get(i).getSpaceId());
            nums = mdspList.get(i).getNums();//获取余票数
            ticketsPrice = (int)(baseTicketsPrice * space.getSpaceDiscount());//计算票价
            ticketsId = flightId + space.getSpaceId();//合成售票编号
            //插入售票信息
            tickets = new Tickets(ticketsId,space.getSpaceId(),flightId,ticketsPrice,nums);
            this.ticketsMapper.create(tickets);
        }
    }

    @Override
    public void setFlightPreTime(String flightId, Time preUpTime, Time preDownTime) {
        Flight flight = new Flight(flightId,null,null,null,null,preUpTime,preDownTime,null,null);
        this.flightMapper.setFlight(flight);
    }

    @Override
    public void setFlightActTime(String flightId, Time actUpTime, Time actDownTime) {
        Flight flight = new Flight(flightId,null,null,null,null,null,null,actUpTime,actDownTime);
        this.flightMapper.setFlight(flight);
    }

    @Override
    public void setFlightState(String flightId,String flightState, String flightInfo) {
        Flight flight = new Flight(flightId,null,null,flightState,flightInfo,null,null,null,null);
        this.flightMapper.setFlight(flight);
    }

    @Override
    public List<InfoOfFlight> findInfoOfFlight(String flightId, String flightsId, Date date) {
        return this.infoOfFlightMapper.findByFlightIdFlightsId(flightId,flightsId,date);
    }

    /**
     * 将Date转换为没有横杠的String
     * @param date
     * @return
     */
    public String dateToString(Date date)
    {
        String s1 = date.toString().substring(0,4);
        String s2 = date.toString().substring(5,7);
        String s3 = date.toString().substring(8,10);
        String dateString = s1 + s2 + s3;
        return dateString;
    }

    /**
     * 计算标准票价
     * @param length
     * @return
     */
    public int calculateBasePrece(int length)
    {
        int price = (int)(Math.log(150)*1.1*length/Math.log(length*0.6));
        return price;
    }
}
