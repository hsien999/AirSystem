package cn.wyx.entity;

import java.io.Serializable;
import java.sql.Time;

/**
 * 航班
 */
public class Flights implements Serializable {
    /**
     *航班号
     */
    private String flightsId;
    /**
     *机型
     */
    private Long modelId;
    /**
     *航线
     */
    private Long airrouteId;
    /**
     *餐食
     */
    private String flightsMeals;
    /**
     *计划起飞时间
     */
    private Time planUpTime;
    /**
     *计划到达时间
     */
    private Time planDownTime;
    /**
     *计划花费时间
     */
    private int planTime;

    public Flights() {
    }

    public Flights(String flightsId, Long modelId, Long airrouteId, String flightsMeals, Time planUpTime, Time planDownTime, int planTime) {
        this.flightsId = flightsId;
        this.modelId = modelId;
        this.airrouteId = airrouteId;
        this.flightsMeals = flightsMeals;
        this.planUpTime = planUpTime;
        this.planDownTime = planDownTime;
        this.planTime = planTime;
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

    public Long getAirrouteId() {
        return airrouteId;
    }

    public void setAirrouteId(Long airrouteId) {
        this.airrouteId = airrouteId;
    }

    public String getFlightsMeals() {
        return flightsMeals;
    }

    public void setFlightsMeals(String flightsMeals) {
        this.flightsMeals = flightsMeals;
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

    public int getPlanTime() {
        return planTime;
    }

    public void setPlanTime(int planTime) {
        this.planTime = planTime;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flightsId='" + flightsId + '\'' +
                ", modelId=" + modelId +
                ", airrouteId=" + airrouteId +
                ", flightsMeals='" + flightsMeals + '\'' +
                ", planUpTime=" + planUpTime +
                ", planDownTime=" + planDownTime +
                ", planTime=" + planTime +
                '}';
    }
}
