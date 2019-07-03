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

    public City() {
    }

    public City(Long cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
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

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
