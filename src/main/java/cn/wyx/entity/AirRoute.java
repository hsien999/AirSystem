package cn.wyx.entity;

import java.io.Serializable;

/**
 * 航线
 */
public class AirRoute implements Serializable {
    /**
     *航线编号
     */
    private Long airrouteId;
    /**
     *航线编号
     */
    private Long airportUp;
    /**
     *终点机场
     */
    private Long airportDown;
    /**
     *航线长度（公里）
     */
    private int airrouteLength;

    public AirRoute(){

    }

    public AirRoute(Long airrouteId, Long airportUp, Long airportDown, int airrouteLength) {
        this.airrouteId = airrouteId;
        this.airportUp = airportUp;
        this.airportDown = airportDown;
        this.airrouteLength = airrouteLength;
    }


    public Long getAirrouteId() {
        return airrouteId;
    }

    public void setAirrouteId(Long airrouteId) {
        this.airrouteId = airrouteId;
    }

    public Long getAirportUp() {
        return airportUp;
    }

    public void setAirportUp(Long airportUp) {
        this.airportUp = airportUp;
    }

    public Long getAirportDown() {
        return airportDown;
    }

    public void setAirportDown(Long airportDown) {
        this.airportDown = airportDown;
    }

    public int getAirrouteLength() {
        return airrouteLength;
    }

    public void setAirrouteLength(int airrouteLength) {
        this.airrouteLength = airrouteLength;
    }

    @Override
    public String toString() {
        return "AirRoute{" +
                "airrouteId=" + airrouteId +
                ", airportUp=" + airportUp +
                ", airportDown=" + airportDown +
                ", airrouteLength=" + airrouteLength +
                '}';
    }
}
