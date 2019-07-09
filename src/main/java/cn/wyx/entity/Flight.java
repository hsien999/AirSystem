package cn.wyx.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * 执飞航班
 */
public class Flight implements Serializable {

    /**
     * 执飞航班编号
     */
    private String flightId;
    /**
     * 航班号
     */
    private String flightsId;
    /**
     * 执飞日期
     */
    private Date flightDate;
    /**
     * 航班状态
     */
    private String flightState;
    /**
     * 航班信息
     */
    private String flightInfo;
    /**
     * 预计起飞时间
     */
    private Time preUpTime;
    /**
     * 预计到达时间
     */
    private Time preDownTime;
    /**
     * 实际起飞时间
     */
    private Time actUpTime;
    /**
     * 实际到达时间
     */
    private Time actDownTime;

    public Flight() {
    }

    public Flight(String flightId, String flightsId, Date flightDate, String flightState, String flightInfo, Time preUpTime, Time preDownTime, Time actUpTime, Time actDownTime) {
        this.flightId = flightId;
        this.flightsId = flightsId;
        this.flightDate = flightDate;
        this.flightState = flightState;
        this.flightInfo = flightInfo;
        this.preUpTime = preUpTime;
        this.preDownTime = preDownTime;
        this.actUpTime = actUpTime;
        this.actDownTime = actDownTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightsId() {
        return flightsId;
    }

    public void setFlightsId(String flightsId) {
        this.flightsId = flightsId;
    }

    public Date getDate() {
        return flightDate;
    }

    public void setDate(Date date) {
        this.flightDate = date;
    }

    public String getFlightState() {
        return flightState;
    }

    public void setFlightState(String flightState) {
        this.flightState = flightState;
    }

    public String getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(String flightInfo) {
        this.flightInfo = flightInfo;
    }

    public Time getPreUpTime() {
        return preUpTime;
    }

    public void setPreUpTime(Time preUpTime) {
        this.preUpTime = preUpTime;
    }

    public Time getPreDownTime() {
        return preDownTime;
    }

    public void setPreDownTime(Time preDownTime) {
        this.preDownTime = preDownTime;
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

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", flightsId='" + flightsId + '\'' +
                ", flightDate=" + flightDate +
                ", flightState='" + flightState + '\'' +
                ", flightInfo='" + flightInfo + '\'' +
                ", preUpTime=" + preUpTime +
                ", preDownTime=" + preDownTime +
                ", actUpTime=" + actUpTime +
                ", actDownTime=" + actDownTime +
                '}';
    }
}
