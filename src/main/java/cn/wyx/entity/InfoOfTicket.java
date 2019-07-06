package cn.wyx.entity;

import java.io.Serializable;

/**
 * 机票信息(包含网上查询信息，和打印信息)
 * @Author: czt
 * @Date: 2019/7/4 18:12
 * @Version 1.0
 */
public class InfoOfTicket implements Serializable {
    /**
     * 机票编号
     */
    private String ticketId;
    /**
     * 乘客名
     */
    private String passengerName;
    /**
     * 乘客电话
     */
    private String passengerTel;
    /**
     * 乘客证件类型
     */
    private String passengerCertype;
    /**
     * 乘客证件号
     */
    private String passengerCerid;
    /**
     * 机票票价
     */
    private int ticketPrice;
    /**
     * 航空保险费
     */
    private int airportFee;
    /**
     * 机场建设费
     */
    private int fuelSurcharge;
    /**
     * 座位号
     */
    private int ticketSeat;
    /**
     * 乘客类型
     */
    private String passengerType;
    /**
     * 舱位编号
     */
    private String spaceId;

    public InfoOfTicket() {
    }

    public InfoOfTicket(String ticketId, String passengerName, String passengerTel, String passengerCertype, String passengerCerid, int ticketPrice, int airportFee, int fuelSurcharge, int ticketSeat, String passengerType, String spaceId) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.passengerTel = passengerTel;
        this.passengerCertype = passengerCertype;
        this.passengerCerid = passengerCerid;
        this.ticketPrice = ticketPrice;
        this.airportFee = airportFee;
        this.fuelSurcharge = fuelSurcharge;
        this.ticketSeat = ticketSeat;
        this.passengerType = passengerType;
        this.spaceId = spaceId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerTel() {
        return passengerTel;
    }

    public void setPassengerTel(String passengerTel) {
        this.passengerTel = passengerTel;
    }

    public String getPassengerCertype() {
        return passengerCertype;
    }

    public void setPassengerCertype(String passengerCertype) {
        this.passengerCertype = passengerCertype;
    }

    public String getPassengerCerid() {
        return passengerCerid;
    }

    public void setPassengerCerid(String passengerCerid) {
        this.passengerCerid = passengerCerid;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAirportFee() {
        return airportFee;
    }

    public void setAirportFee(int airportFee) {
        this.airportFee = airportFee;
    }

    public int getFuelSurcharge() {
        return fuelSurcharge;
    }

    public void setFuelSurcharge(int fuelSurcharge) {
        this.fuelSurcharge = fuelSurcharge;
    }

    public int getTicketSeat() {
        return ticketSeat;
    }

    public void setTicketSeat(int ticketSeat) {
        this.ticketSeat = ticketSeat;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    @Override
    public String toString() {
        return "InfoOfTicket{" +
                "ticketId='" + ticketId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerTel='" + passengerTel + '\'' +
                ", passengerCertype='" + passengerCertype + '\'' +
                ", passengerCerid='" + passengerCerid + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", airportFee=" + airportFee +
                ", fuelSurcharge=" + fuelSurcharge +
                ", ticketSeat=" + ticketSeat +
                ", passengerType='" + passengerType + '\'' +
                ", spaceId='" + spaceId + '\'' +
                '}';
    }
}
