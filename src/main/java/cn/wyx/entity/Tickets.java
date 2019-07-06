package cn.wyx.entity;

import java.io.Serializable;

/**
 *航班售票
 */
public class Tickets implements Serializable {
    /**
     *售票编号
     */
    private String ticketsId;
    /**
     *舱位编号
     */
    private String spaceId;
    /**
     *执飞航班编号
     */
    private String flightId;
    /**
     *票价
     */
    private int ticketsPrice;
    /**
     *余票数
     */
    private int ticketsNums;

    public Tickets() {
    }

    public Tickets(String ticketsId, String spaceId, String flightId, int ticketsPrice, int ticketsNums) {
        this.ticketsId = ticketsId;
        this.spaceId = spaceId;
        this.flightId = flightId;
        this.ticketsPrice = ticketsPrice;
        this.ticketsNums = ticketsNums;
    }

    public String getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(String ticketsId) {
        this.ticketsId = ticketsId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getTicketsPrice() {
        return ticketsPrice;
    }

    public void setTicketsPrice(int ticketsPrice) {
        this.ticketsPrice = ticketsPrice;
    }

    public int getTicketsNums() {
        return ticketsNums;
    }

    public void setTicketsNums(int ticketsNums) {
        this.ticketsNums = ticketsNums;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketsId='" + ticketsId + '\'' +
                ", spaceId='" + spaceId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", ticketsPrice=" + ticketsPrice +
                ", ticketsNums=" + ticketsNums +
                '}';
    }
}
