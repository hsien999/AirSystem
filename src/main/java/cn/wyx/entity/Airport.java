package cn.wyx.entity;

import java.io.Serializable;

/**
 * 机场
 */
public class Airport implements Serializable {
    /**
     * 机场编号
     */
    private Long airportId;
    /**
     *城市编号
     */
    private Long cityId;
    /**
     *机场名称
     */
    private String airportName;


    public Airport() {
    }

    public Airport(Long airportId, Long cityId, String airportName) {
        this.airportId = airportId;
        this.cityId = cityId;
        this.airportName = airportName;
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportId=" + airportId +
                ", cityId=" + cityId +
                ", airportName='" + airportName + '\'' +
                '}';
    }
}
