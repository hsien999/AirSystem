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
    private String cityAlp;

    public City() {
    }

    public City(Long cityId, String cityName, String cityAlp) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityAlp = cityAlp;
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

    public String getCityAlp() {
        return cityAlp;
    }

    public void setCityAlp(String cityAlp) {
        this.cityAlp = cityAlp;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityAlp='" + cityAlp + '\'' +
                '}';
    }
}
