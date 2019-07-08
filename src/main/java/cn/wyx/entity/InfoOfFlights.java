package cn.wyx.entity;

import java.sql.Time;

/**
 * 航班相关信息
 * @Author: czt
 * @Date: 2019/7/8 12:17
 * @Version 1.0
 */
public class InfoOfFlights {
    /**
     * 航班号
     */
    private String flightsId;
    /**
     * 机型Id
     */
    private Long modelId;
    /**
     * 餐食
     */
    private String fightsMeals;
    /**
     * 计划起飞时间
     */
    private Time planUpTime;
    /**
     * 计划飞行时间
     */
    private int planTime;
    /**
     * 起飞机场名
     */
    private String airportUpName;
    /**
     * 降落机场名
     */
    private String airportDownName;
    /**
     * 航线距离
     */
    private int airRouteLength;

    public InfoOfFlights() {
    }

    public InfoOfFlights(String flightsId, Long modelId, String fightsMeals, Time plantUpTime, int planTime, String airportUpName, String airportDownName, int airRouteLength) {
        this.flightsId = flightsId;
        this.modelId = modelId;
        this.fightsMeals = fightsMeals;
        this.planUpTime = plantUpTime;
        this.planTime = planTime;
        this.airportUpName = airportUpName;
        this.airportDownName = airportDownName;
        this.airRouteLength = airRouteLength;
    }

    public String getFlightsId() {
        return flightsId;
    }

    public void setFlightsId(String flightsId) {
        this.flightsId = flightsId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getFightsMeals() {
        return fightsMeals;
    }

    public void setFightsMeals(String fightsMeals) {
        this.fightsMeals = fightsMeals;
    }

    public Time getPlantUpTime() {
        return planUpTime;
    }

    public void setPlantUpTime(Time plantUpTime) {
        this.planUpTime = plantUpTime;
    }

    public int getPlanTime() {
        return planTime;
    }

    public void setPlanTime(int planTime) {
        this.planTime = planTime;
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

    public int getAirRouteLength() {
        return airRouteLength;
    }

    public void setAirRouteLength(int airRouteLength) {
        this.airRouteLength = airRouteLength;
    }

    @Override
    public String toString() {
        return "InfoOfFlights{" +
                "flightsId='" + flightsId + '\'' +
                ", modelId=" + modelId +
                ", fightsMeals='" + fightsMeals + '\'' +
                ", plantUpTime=" + planUpTime +
                ", planTime=" + planTime +
                ", airportUpName='" + airportUpName + '\'' +
                ", airportDownName='" + airportDownName + '\'' +
                ", airRouteLength=" + airRouteLength +
                '}';
    }
}
