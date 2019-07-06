package cn.wyx.entity;

import java.io.Serializable;

/**
 * 城市
 */
public class City implements Serializable {
    /**
     * 城市编号
     */
    private Long cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 城市名首字母
     */
    private String city_alp;

    public City() {
    }

    public City(Long cityId, String cityName, String city_alp) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.city_alp = city_alp;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCity_alp() {
        return city_alp;
    }

    public void setCity_alp(String city_alp) {
        this.city_alp = city_alp;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", city_alp='" + city_alp + '\'' +
                '}';
    }
}
