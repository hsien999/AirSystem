package cn.wyx.mapper;

import cn.wyx.entity.City;
import org.apache.ibatis.annotations.Param;

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
     * 获取城市编号
     * @param cityName
     * @return
     */
    City getCityIdByName(String cityName);

    /**
     * 设置城市信息
     * @param city
     */
    void setCity(City city);
}
