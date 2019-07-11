package cn.wyx.entity.request;

import cn.wyx.entity.Order;
import cn.wyx.entity.Passenger;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wyx
 * @Date: 2019/7/10 15:20
 * @Version 1.0
 *
 * 用户下订单请求的封装类
 */
public class OrderTicketData implements Serializable {
    private String ticketsId;
    private Order order;
    private List<Passenger> passengerList;

    public OrderTicketData() {
    }

    public OrderTicketData(String ticketsId, Order order, List<Passenger> passengerList) {
        this.ticketsId = ticketsId;
        this.order = order;
        this.passengerList = passengerList;
    }

    public String getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(String ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "OrderTicketData{" +
                "ticketsId='" + ticketsId + '\'' +
                ", order=" + order +
                ", passengerList=" + passengerList +
                '}';
    }
}
