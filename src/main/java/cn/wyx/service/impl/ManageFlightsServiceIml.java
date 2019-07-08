package cn.wyx.service.impl;

import cn.wyx.entity.*;
import cn.wyx.mapper.*;
import cn.wyx.service.ManageFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/7 22:01
 * @Version 1.0
 */
@Service
public class ManageFlightsServiceIml implements ManageFlightsService {


    @Autowired
    private AirRouteMapper airRouteMapper;
    @Autowired
    private AirportMapper airportMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FlightsMapper flightsMapper;
    @Autowired
    private InfoOfFlightsMapper infoOfFlightsMapper;

    @Override
    public void createAirRoute(String airportUpName, String airportDownName, int length) {

        //获取机场对象
        Airport airportUp = this.airportMapper.findAirportByAirportName(airportUpName);
        Airport airportDown = this.airportMapper.findAirportByAirportName(airportDownName);

        AirRoute airRoute = findAirRouteByAirportsName(airportUpName,airportDownName);

        if(airRoute == null )//当航线不存在数据库中时插入新航线
        {
            AirRoute airRoute2 = new AirRoute(null,airportUp.getAirportId(),airportDown.getAirportId(),length);
            this.airRouteMapper.create(airRoute2);
        }
        else if (airRoute.getAirrouteLength() != length )//当航线存在，但航线长度改变时，修改数据库
        {
            this.airRouteMapper.setLengthByAirports(airportUpName,airportDownName,length);
        }
    }

    @Override
    public List<AirRoute> findAirRouteByCitiesName(String startCityName, String endCityName) {
        return this.airRouteMapper.findByCities(startCityName,endCityName);
    }

    @Override
    public AirRoute findAirRouteByAirportsName(String airportUpName, String airportDownName) {
        List<AirRoute> airRoutes = this.airRouteMapper.findByAirports(airportUpName,airportDownName);
        if(airRoutes!=null&&airRoutes.size()>0)
            return airRoutes.get(0);
        return null;
    }

    @Override
    public void setLengthByAirportsName(String airportUpName, String airportDownName, int length) {
        this.airRouteMapper.setLengthByAirports(airportUpName,airportDownName,length);
    }

    @Override
    public int calculatePlanTime(Long modelId, int length) {
        int planTime = 0;
        try{
            //获取 机型对象 以获取 机型时速
            List<Model> models = this.modelMapper.findModel(modelId,null);
            if(models!=null&&models.size()>0)
            {
                int speed = models.get(0).getModelSpeed();
                planTime = (int)(length*60/speed);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return planTime;
    }

    @Override
    public Time calculatePlanDownTime(Time planUpTime, int planTime) {
        //时间转换
        int dHour = planTime/60;
        int dMinute = planTime%60;
        int hour = Integer.valueOf(planUpTime.toString().substring(0,2));
        int minute = Integer.valueOf(planUpTime.toString().substring(3,5));

        minute = (minute + dMinute);
        hour = (hour + dHour + minute/60)%24;
        minute = minute%60;

        Time planDownTime = Time.valueOf(hour + ":" + minute + ":00");
        return planDownTime;
    }

    @Override
    public void setFlights(InfoOfFlights infoOfFlights) {

        //更新先航线
        this.createAirRoute(infoOfFlights.getAirportUpName(),infoOfFlights.getAirportDownName(),infoOfFlights.getAirRouteLength());

        //获取航线对象以获取航线编号
        AirRoute airRoute = findAirRouteByAirportsName(infoOfFlights.getAirportUpName(),infoOfFlights.getAirportDownName());

        //更新航班
        Time planDownTime = calculatePlanDownTime(infoOfFlights.getPlantUpTime(),infoOfFlights.getPlanTime());//计算计划到达时间

        Flights flights = new Flights(infoOfFlights.getFlightsId(),infoOfFlights.getModelId(),airRoute.getAirrouteId(),
                infoOfFlights.getFightsMeals(),infoOfFlights.getPlantUpTime(),planDownTime,infoOfFlights.getPlanTime());
        this.flightsMapper.setFlights(flights);
    }

    @Override
    public List<InfoOfFlights> findFlights(String flightsId, String airportUpName, String airportDownName) {
        return this.infoOfFlightsMapper.findFlights(flightsId,airportUpName,airportDownName);
    }

    @Override
    public void createFlights(InfoOfFlights infoOfFlights) {
        //创建航线
        createAirRoute(infoOfFlights.getAirportUpName(),infoOfFlights.getAirportDownName(),infoOfFlights.getAirRouteLength());

        //创建航班
        AirRoute airRoute = findAirRouteByAirportsName(infoOfFlights.getAirportUpName(),infoOfFlights.getAirportDownName());//获取航线对象
        Time planDownTime = calculatePlanDownTime(infoOfFlights.getPlantUpTime(),infoOfFlights.getPlanTime());//计算到达时间

        Flights flights = new Flights(infoOfFlights.getFlightsId(),infoOfFlights.getModelId(),
                airRoute.getAirrouteId(),infoOfFlights.getFightsMeals(),infoOfFlights.getPlantUpTime(),planDownTime,infoOfFlights.getPlanTime());
        this.flightsMapper.create(flights); //将航班信息插入数据库
    }
}
