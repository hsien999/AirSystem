package cn.wyx.entity;

import java.io.Serializable;

/**
 * 机票
 */
public class Ticket implements Serializable {
    /**
     *机票编号
     */
    private String ticketId;
    /**
     *售票编号
     */
    private String ticketsId;
    /**
     *订单编号
     */
    private String orderId;
    /**
     *票价
     */
    private int ticketPrice;
    /**
     *机场建设费
     */
    private int fuelSurcharge;
    /**
     *航空保险费
     */
    private int airportFee;
    /**
     * 座位号
     */
    private int ticketSeat;


    public Ticket() {
    }

    public Ticket(String ticketId, String ticketsId, String orderId, int ticketPrice, int fuelSurcharge, int airportFee, int ticketSeat) {
        this.ticketId = ticketId;
        this.ticketsId = ticketsId;
        this.orderId = orderId;
        this.ticketPrice = ticketPrice;
        this.fuelSurcharge = fuelSurcharge;
        this.airportFee = airportFee;
        this.ticketSeat = ticketSeat;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(String ticketsId) {
        this.ticketsId = ticketsId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getFuelSurcharge() {
        return fuelSurcharge;
    }

    public void setFuelSurcharge(int fuelSurcharge) {
        this.fuelSurcharge = fuelSurcharge;
    }

    public int getAirportFee() {
        return airportFee;
    }

    public void setAirportFee(int airportFee) {
        this.airportFee = airportFee;
    }

    public int getTicketSeat() {
        return ticketSeat;
    }

    public void setTicketSeat(int ticketSeat) {
        this.ticketSeat = ticketSeat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketsId='" + ticketsId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", fuelSurcharge=" + fuelSurcharge +
                ", airportFee=" + airportFee +
                ", ticketSeat=" + ticketSeat +
                '}';
    }
}
