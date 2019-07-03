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
    private Date date;
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
    private Time pre_upTime;
    /**
     * 预计到达时间
     */
    private Time pre_downTime;
    /**
     * 实际起飞时间
     */
    private Time act_upTime;
    /**
     * 实际到达时间
     */
    private Time act_downTime;

    public Flight() {
    }

    public Flight(String flightId, String flightsId, Date date, String flightState, String flightInfo, Time pre_upTime, Time pre_downTime, Time act_upTime, Time act_downTime) {
        this.flightId = flightId;
        this.flightsId = flightsId;
        this.date = date;
        this.flightState = flightState;
        this.flightInfo = flightInfo;
        this.pre_upTime = pre_upTime;
        this.pre_downTime = pre_downTime;
        this.act_upTime = act_upTime;
        this.act_downTime = act_downTime;
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
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Time getPre_upTime() {
        return pre_upTime;
    }

    public void setPre_upTime(Time pre_upTime) {
        this.pre_upTime = pre_upTime;
    }

    public Time getPre_downTime() {
        return pre_downTime;
    }

    public void setPre_downTime(Time pre_downTime) {
        this.pre_downTime = pre_downTime;
    }

    public Time getAct_upTime() {
        return act_upTime;
    }

    public void setAct_upTime(Time act_upTime) {
        this.act_upTime = act_upTime;
    }

    public Time getAct_downTime() {
        return act_downTime;
    }

    public void setAct_downTime(Time act_downTime) {
        this.act_downTime = act_downTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", flightsId='" + flightsId + '\'' +
                ", date=" + date +
                ", flightState='" + flightState + '\'' +
                ", flightInfo='" + flightInfo + '\'' +
                ", pre_upTime=" + pre_upTime +
                ", pre_downTime=" + pre_downTime +
                ", act_upTime=" + act_upTime +
                ", act_downTime=" + act_downTime +
                '}';
    }
}
