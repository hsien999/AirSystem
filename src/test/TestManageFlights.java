import cn.wyx.entity.AirRoute;
import cn.wyx.entity.InfoOfFlight;
import cn.wyx.entity.InfoOfFlights;
import cn.wyx.service.ManageFlightsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/7 23:23
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestManageFlights {
    @Autowired
    private ManageFlightsService manageFlightsService;

    @Test
    public void creatRoute()
    {
        this.manageFlightsService.createAirRoute("北京机场","上海机场",1000);
        this.manageFlightsService.createAirRoute("上海机场","北京机场",1200);
        this.manageFlightsService.createAirRoute("北京机场","天津机场",1000);
        this.manageFlightsService.createAirRoute("北京机场","天津机场",1400);
    }

    @Test
    public void findRoute()
    {
//        List<AirRoute> airRoutes = this.manageFlightsService.findAirRouteByCitiesName("北京","上海");
//        System.out.println(airRoutes);
        AirRoute airRoute = this.manageFlightsService.findAirRouteByAirportsName("北京机场" ,"上海机场");
        System.out.println("2222"+ airRoute);
    }




    @Test
    public void createFlights()
    {
        Time time = Time.valueOf("12:00:00");
        InfoOfFlights infoOfFlights = new InfoOfFlights("JM1010",1L,"无",time ,72,"北京机场","上海机场",2000);
        this.manageFlightsService.createFlights(infoOfFlights);
    }

    @Test
    public void calculate()
    {
         Long modelId = 1L;
         int length = 1500;
         int planTime = this.manageFlightsService.calculatePlanTime(modelId,length);
         Time planUpTime = Time.valueOf("23:00:00");
         Time planDownTime = this.manageFlightsService.calculatePlanDownTime(planUpTime,planTime);
         System.out.println(planUpTime + "---" + planDownTime + "----" + planTime);
    }
    @Test
    public void findFlights()
    {
        List<InfoOfFlights>  infoOfFlights = this.manageFlightsService.findFlights(null,"北京机场","上海机场");
    }

    @Test
    public void setFlights()
    {
        Time planUpTime = Time.valueOf("1:10:00");
        InfoOfFlights infoOfFlights = new InfoOfFlights("JM1010",1L,"午餐" ,planUpTime,60,"北京机场","天津机场" ,650);
        this.manageFlightsService.setFlights(infoOfFlights);
    }
}
