package cn.wyx.entity;

import java.io.Serializable;

/**
 *乘机人信息
 */
public class Passenger implements Serializable {
    /**
     *乘客人编号
     */
    private Long passengerId;
    /**
     *机票编号
     */
    private String ticketId;
    /**
     *乘客人姓名
     */
    private String passengerName;
    /**
     *证件号
     */
    private String passengerCerid;
    /**
     *证件类型
     */
    private String passengerCertype;
    /**
     *乘客人手机号码
     */
    private String passengerTel;
    /**
     *乘客类型
     */
    private String passengerTyep;


    public Passenger() {
    }

    public Passenger(Long passengerId, String ticketId, String passengerName, String passengerCerid, String passengerCertype, String passengerTel, String passengerTyep) {
        this.passengerId = passengerId;
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.passengerCerid = passengerCerid;
        this.passengerCertype = passengerCertype;
        this.passengerTel = passengerTel;
        this.passengerTyep = passengerTyep;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
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

    public String getPassengerCerid() {
        return passengerCerid;
    }

    public void setPassengerCerid(String passengerCerid) {
        this.passengerCerid = passengerCerid;
    }

    public String getPassengerCertype() {
        return passengerCertype;
    }

    public void setPassengerCertype(String passengerCertype) {
        this.passengerCertype = passengerCertype;
    }

    public String getPassengerTel() {
        return passengerTel;
    }

    public void setPassengerTel(String passengerTel) {
        this.passengerTel = passengerTel;
    }

    public String getPassengerTyep() {
        return passengerTyep;
    }

    public void setPassengerTyep(String passengerTyep) {
        this.passengerTyep = passengerTyep;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", ticketId='" + ticketId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerCerid='" + passengerCerid + '\'' +
                ", passengerCertype='" + passengerCertype + '\'' +
                ", passengerTel='" + passengerTel + '\'' +
                ", passengerTyep='" + passengerTyep + '\'' +
                '}';
    }
}
