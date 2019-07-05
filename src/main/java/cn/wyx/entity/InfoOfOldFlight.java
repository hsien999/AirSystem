package cn.wyx.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * @Author: czt
 * @Date: 2019/7/3 19:41
 * @Version 1.0
 * 航班动态查询的航班信息
 */
public class InfoOfOldFlight implements Serializable {
    /**
     * 航班号
     */
    private String flightsId;
    /**
     *执飞航班编号
     */
    private String flightId;
    /**
     *飞行日期
     */
    private Date date;
    /**
     *机型名称
     */
    private String modelName;
    /**
     *起点机场名
     */
    private String airportUpName;
    /**
     *终点机场名
     */
    private String airportDownName;
    /**
     *起点城市名
     */
    private String cityStartName;
    /**
     *终点城市名
     */
    private String cityEndName;
    /**
     *计划起飞时间
     */
    private Time planUpTime;
    /**
     *计划到达时间
     */
    private Time planDownTime;
    /**
     * 实际起飞时间
     */
    private Time actUpTime;
    /**
     * 实际到达时间
     */
    private Time actDownTime;
    /**
     *航班状态
     */
    private String state;

    public InfoOfOldFlight() {
    }

    public InfoOfOldFlight(String flightsId, String filghtId, Date date, String modelName, String airportUpName, String airportDownName, String cityStartName, String cityEndName, Time planUpTime, Time planDownTime, Time actUpTime, Time actDownTime, String state) {
        this.flightsId = flightsId;
        this.flightId = filghtId;
        this.date = date;
        this.modelName = modelName;
        this.airportUpName = airportUpName;
        this.airportDownName = airportDownName;
        this.cityStartName = cityStartName;
        this.cityEndName = cityEndName;
        this.planUpTime = planUpTime;
        this.planDownTime = planDownTime;
        this.actUpTime = actUpTime;
        this.actDownTime = actDownTime;
        this.state = state;
    }

    public String getFlightsId() {
        return flightsId;
    }

    public void setFlightsId(String flightsId) {
        this.flightsId = flightsId;
    }

    public String getFilghtId() {
        return flightId;
    }

    public void setFilghtId(String filghtId) {
        this.flightId = filghtId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAirportUpName() {
        return airportUpName;
    }

    public void setAirportUpName(String airportUpName) {
        this.airportUpName = airportUpName;
    }

    public String getAirportDownName() {
        return airportDownName;
    }

    public void setAirportDownName(String airportDownName) {
        this.airportDownName = airportDownName;
    }

    public String getCityStartName() {
        return cityStartName;
    }

    public void setCityStartName(String cityStartName) {
        this.cityStartName = cityStartName;
    }

    public String getCityEndName() {
        return cityEndName;
    }

    public void setCityEndName(String cityEndName) {
        this.cityEndName = cityEndName;
    }

    public Time getPlanUpTime() {
        return planUpTime;
    }

    public void setPlanUpTime(Time planUpTime) {
        this.planUpTime = planUpTime;
    }

    public Time getPlanDownTime() {
        return planDownTime;
    }

    public void setPlanDownTime(Time planDownTime) {
        this.planDownTime = planDownTime;
    }

    public Time getActUpTime() {
        return actUpTime;
    }

    public void setActUpTime(Time actUpTime) {
        this.actUpTime = actUpTime;
    }

    public Time getActDownTime() {
        return actDownTime;
    }

    public void setActDownTime(Time actDownTime) {
        this.actDownTime = actDownTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "InfoOfOldFlight{" +
                "flightsId='" + flightsId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", date=" + date +
                ", modelName='" + modelName + '\'' +
                ", airportUpName='" + airportUpName + '\'' +
                ", airportDownName='" + airportDownName + '\'' +
                ", cityStartName='" + cityStartName + '\'' +
                ", cityEndName='" + cityEndName + '\'' +
                ", planUpTime=" + planUpTime +
                ", planDownTime=" + planDownTime +
                ", actUpTime=" + actUpTime +
                ", actDownTime=" + actDownTime +
                ", state='" + state + '\'' +
                '}';
    }
}
