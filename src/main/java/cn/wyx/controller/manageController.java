package cn.wyx.controller;

import cn.wyx.entity.*;
import cn.wyx.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.jsqlparser.expression.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/11 14:55
 * @Version 1.0
 */
@RestController
public class manageController {
    @Autowired
    private CityAirportService cityAirportService;
    @Autowired
    private ModelSpaceRuleService modelSpaceRuleService;
    @Autowired
    private InfoOfOldFlightService infoOfOldFlightService;
    @Autowired
    private ManageFlightService manageFlightService;
    @Autowired
    private ManageFlightsService manageFlightsService;


    @RequestMapping("/insertCity")
    public Result insertCity(@RequestParam String cityName, @RequestParam String cityAlp) {
        try {
            if (cityAirportService.getCityByName(cityName) == null) {
                cityAirportService.createCity(cityName, cityAlp);
                return new Result(true, "插入成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "插入失败");
    }

    @RequestMapping("/addMdsp")
    public Result addMdsp(@RequestParam String spaceId, @RequestParam Long modelId, @RequestParam int nums) {
        try {
            List<Mdsp> mdsps = this.modelSpaceRuleService.findMdsp(modelId, spaceId);
            Mdsp mdsp = new Mdsp(modelId, spaceId, nums);
            if (mdsps == null || mdsps.size() == 0) {
                this.modelSpaceRuleService.createMdsp(mdsp);
                return new Result(true, "添加成功");
            } else {
                this.modelSpaceRuleService.setMdspNums(mdsp);
                return new Result(true, "修改成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "插入失败");
    }

    @RequestMapping("/addAirport")
    public Result addAirport(@RequestParam String cityName, @RequestParam String airportName) {
        try {
            Airport airport = this.cityAirportService.findAirportByAirportName(airportName);
            if (airport != null) return new Result(false, "机场已存在");
            this.cityAirportService.createAirport(cityName, airportName);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "插入失败");
    }

    @RequestMapping("/findCityByAlp")
    public List<City> findCityByAlp(@RequestParam String cityAlp) {
        return this.cityAirportService.getCityByAlp(cityAlp);
    }

    @RequestMapping("/getSpaceById")
    public List<Space> getSpaceById(@RequestParam Long modelId) {
        return this.modelSpaceRuleService.findSpaceByRelatedModelId(modelId);
    }

    @RequestMapping("/showAllSpace")
    public List<Space> showAllSpace() {
//        System.out.println("22222222222222222222");
        return this.modelSpaceRuleService.findAllSpace();
    }

    @RequestMapping("/getAllModel")
    public List<Model> getAllModel() {
        System.out.println("1111111111111111111");
        return this.modelSpaceRuleService.findAllModel();
    }

    @RequestMapping("/getAllCity")
    public List<City> getAllCity() {
        return this.cityAirportService.findAllCity();
    }

    @RequestMapping("/insertSpaceGroup")
    public Result insertSpaceGroup(@RequestBody SpaceGroup spaceGroup) {
        try {
            Space space = spaceGroup.getSpace();
//            System.out.println("111111:"+space);
//            System.out.println("222222:"+spaceGroup);

            Space space2 = this.modelSpaceRuleService.findSpaceById(space.getSpaceId());
            if (space2 != null) return new Result(false, "舱型编号已存在！");

            Rule rule1 = spaceGroup.getRule1();
            rule1.setSpaceId(space.getSpaceId());
            Rule rule2 = spaceGroup.getRule2();
            rule2.setSpaceId(space.getSpaceId());
            Rule rule3 = spaceGroup.getRule2();
            rule3.setSpaceId(space.getSpaceId());
            Rule rule4 = spaceGroup.getRule4();
            rule4.setSpaceId(space.getSpaceId());
            this.modelSpaceRuleService.createSpace(space);
            this.modelSpaceRuleService.createRule(rule1);
            this.modelSpaceRuleService.createRule(rule2);
            this.modelSpaceRuleService.createRule(rule3);
            this.modelSpaceRuleService.createRule(rule4);
            return new Result(true, "插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "插入失败");
    }

    @RequestMapping("/addModel")
    public Result addModel(@RequestBody Model model) {
        try {
            Model model1 = this.modelSpaceRuleService.findModelByModelName(model.getModelName());
            if (model1 != null) return new Result(false, "机型已存在");
            this.modelSpaceRuleService.createModel(model);
            return new Result(true, "插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "插入失败");
    }

    @RequestMapping("/getAirportByCityName")
    public List<Airport> getAirportByCityName(@RequestParam String cityName) {
        try {
            List<Airport> airportList = this.cityAirportService.findAirportByCityName(cityName);
            System.out.println("airportList  === " + airportList);
            return airportList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/getAllAirport")
    public List<Airport>getAllAirport(){
        try{
            return this.cityAirportService.findAirportByCityName(null);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/insertFlights")
    public Result insertFlight(@RequestBody InfoOfFlights infoOfFlights) {
        System.out.println("555555555555555555555"+infoOfFlights);
        try {
            List<InfoOfFlights> infoOfFlightsList = this.manageFlightsService.findFlights(infoOfFlights.getFlightsId(),null,null);
            System.out.println("555555555555555555555"+infoOfFlightsList);
            System.out.println("666666666666"+infoOfFlightsList.size());
            if(infoOfFlightsList!=null&&infoOfFlightsList.size()>0)
                return new Result(false,"航班号已存在");
            this.manageFlightsService.createFlights(infoOfFlights);
            return new Result(true, "插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "插入失败");
    }
    @RequestMapping("/searchFlight")
    public List<InfoOfOldFlight> searchFlight(@RequestParam String flightsId) {
        try {
            List<InfoOfOldFlight> infoOfOldFlightList = this.infoOfOldFlightService.findOldFlightByFlightIdFlightsIdDate(null, flightsId, null);
            System.out.println("InfoOfOldFlight ==== " + infoOfOldFlightList);
            return infoOfOldFlightList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/insertFlight")
    public Result insertFlight(@RequestParam String flightsId, @RequestParam String flightDate, @RequestParam String preUpTime, @RequestParam String preDownTime) {
        try {
            this.manageFlightService.CreateFlight(flightsId, Date.valueOf(flightDate), Time.valueOf(preUpTime), Time.valueOf(preDownTime));
            return new Result(true, "'添加成功'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "添加失败");
    }


    @RequestMapping("/doUpdateFlight")
    public Result doUpdateFlight(@RequestParam String flightId, @RequestParam String preUpTime, @RequestParam String preDownTime, @RequestParam String actUpTime,
                                 @RequestParam String actDownTime, @RequestParam String state, @RequestParam String flightInfo) {
        try {
            this.manageFlightService.setFlightPreTime(flightId, Time.valueOf(preUpTime), Time.valueOf(preDownTime));
            this.manageFlightService.setFlightActTime(flightId, Time.valueOf(actUpTime), Time.valueOf(actDownTime));
            this.manageFlightService.setFlightState(flightId, state, flightInfo);
            return new Result(true, "'更新成功'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "更新失败");
    }

}
