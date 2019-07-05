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
    private char city_alp;

    public City() {
    }

    public City(Long cityId, String cityName, char city_alp) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.city_alp = city_alp;
    }

    public char getCity_alp() {
        return city_alp;
    }

    public void setCity_alp(char city_alp) {
        this.city_alp = city_alp;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", city_alp=" + city_alp +
                '}';
    }
}
