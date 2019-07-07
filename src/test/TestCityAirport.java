import cn.wyx.entity.Airport;
import cn.wyx.entity.City;
import cn.wyx.entity.UserPass;
import cn.wyx.service.CityAirportService;
import cn.wyx.service.UserPassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 11:23
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestCityAirport {
    @Autowired
    CityAirportService cityAirportService;

    @Test
    public void create()
    {
        this.cityAirportService.createCity("天津","T");
        this.cityAirportService.createAirport("天津" ,"天津机场");
    }

    @Test
    public void set()
    {
        City city = new City(1L,"北京","B");
        this.cityAirportService.setCity(city);
        Airport airport = new Airport(1L,1L,"北京机场");
        this.cityAirportService.setAirport(airport);
    }

    @Test
    public void select()
    {
        City city = this.cityAirportService.getCityByName("北京");
        List<Airport> airportList = this.cityAirportService.findAirportByCityName("北京");
        Airport airport = this.cityAirportService.findAirportByAirportName("北京机场");

        System.out.println(city);
        System.out.println(airportList);
        System.out.println(airport);
    }
}
