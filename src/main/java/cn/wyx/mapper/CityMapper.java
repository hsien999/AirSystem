package cn.wyx.mapper;

import cn.wyx.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 22:25
 * @Version 1.0
 */
public interface CityMapper {
    /**
     * 创建新城市
     * @param cityName
     * @param cityAlp
     */
    void create(@Param("cityName") String cityName, @Param("cityAlp") String cityAlp);

    /**
     * 获取城市对象
     * @param cityName
     * @return
     */
    City getCityIdByName(String cityName);

    /**
     * 通过首字母查找城市
     * @param cityAlp
     * @return
     */
    List<City> getCitiesByAlp(String cityAlp);

    /**
     * 设置城市信息
     * @param city
     */
    void setCity(City city);

    /**
     * 获取所有城市
     * @return
     */
    List<City>getAllCity();
}
