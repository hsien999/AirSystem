package cn.wyx.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * 订票查询显示的执飞航班信息
 */
public class InfoOfFlight implements Serializable {

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
     *机型速度
     */
    private String modelSpeed;
    /**
     *餐食名称
     */
    private String flightsMeals;
    /**
     *航线路程（公里）
     */
    private String airrouteLength;
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
     *预计起飞时间
     */
    private Time preUpTime;
    /**
     *预计到达时间
     */
    private Time preDownTime;
    /**
     *计划飞行时间
     */
    private int planTime;
    /**
     * 此执飞航班的机票相关信息
     */
    private List<InfoOfTickets> tickets;


    public InfoOfFlight() {
    }

    public InfoOfFlight(String flightsId, String flightId, Date date, String modelName, String modelSpeed, String flightsMeals, String airrouteLength, String airportUpName, String airportDownName, String cityStartName, String cityEndName, Time preUpTime, Time preDownTime, int planTime, List<InfoOfTickets> tickets) {
        this.flightsId = flightsId;
        this.flightId = flightId;
        this.date = date;
        this.modelName = modelName;
        this.modelSpeed = modelSpeed;
        this.flightsMeals = flightsMeals;
        this.airrouteLength = airrouteLength;
        this.airportUpName = airportUpName;
        this.airportDownName = airportDownName;
        this.cityStartName = cityStartName;
        this.cityEndName = cityEndName;
        this.preUpTime = preUpTime;
        this.preDownTime = preDownTime;
        this.planTime = planTime;
        this.tickets = tickets;
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

    public String getModelSpeed() {
        return modelSpeed;
    }

    public void setModelSpeed(String modelSpeed) {
        this.modelSpeed = modelSpeed;
    }

    public String getFlightsMeals() {
        return flightsMeals;
    }

    public void setFlightsMeals(String flightsMeals) {
        this.flightsMeals = flightsMeals;
    }

    public String getAirrouteLength() {
        return airrouteLength;
    }

    public void setAirrouteLength(String airrouteLength) {
        this.airrouteLength = airrouteLength;
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

    public int getPlanTime() {
        return planTime;
    }

    public void setPlanTime(int planTime) {
        this.planTime = planTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public List<InfoOfTickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<InfoOfTickets> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "InfoOfFlight{" +
                "flightsId='" + flightsId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", date=" + date +
                ", modelName='" + modelName + '\'' +
                ", modelSpeed='" + modelSpeed + '\'' +
                ", flightsMeals='" + flightsMeals + '\'' +
                ", airrouteLength='" + airrouteLength + '\'' +
                ", airportUpName='" + airportUpName + '\'' +
                ", airportDownName='" + airportDownName + '\'' +
                ", cityStartName='" + cityStartName + '\'' +
                ", cityEndName='" + cityEndName + '\'' +
                ", preUpTime=" + preUpTime +
                ", preDownTime=" + preDownTime +
                ", planTime=" + planTime +
                ", tickets=" + tickets +
                '}';
    }
}
