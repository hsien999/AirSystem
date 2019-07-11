package cn.wyx.entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.List;

/**订单信息
 * @Author: czt
 * @Date: 2019/7/4 18:29
 * @Version 1.0
 */
public class InfoOfOrder implements Serializable {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单总价
     */
    private int orderPrice;
    /**
     * 订单提交时间
     */
    private Timestamp orderSureTime;
    /**
     * 起点城市名
     */
    private String startCityName;
    /**
     * 终点城市名
     */
    private String endCityName;
    /**
     * 起飞机场
     */
    private String upAirportName;
    /**
     * 降落机场
     */
    private String downAirportName;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 联系人姓名
     */
    private String orderContactName;
    /**
     * 联系人电话
     */
    private String orderContactTel;
    /**
     * 联系人邮箱
     */
    private String orderContactEmail;
    /**
     * 航班号
     */
    private String flightsId;
    /**
     * 乘客人数
     */
    private int orderNums;
    /**
     * 预计起飞时间
     */
    private Time preUpTime;
    /**
     * 预计到达时间
     */
    private Time preDownTime;
    /**
     * 机型名称
     */
    private String ModelName;
    /**
     * 餐食
     */
    private String flightsMeal;
    /**
     * 机票信息
     */
    private List<InfoOfTicket> tickets;

    public InfoOfOrder() {
    }

    public InfoOfOrder(String orderId, int orderPrice, Timestamp orderSureTime, String startCityName, String endCityName, String upAirportName, String downAirportName, String orderState, String orderContactName, String orderContactTel, String orderContactEmail, String flightsId, int orderNums, Time preUpTime, Time preDownTime, String modelName, String flightsMeal, List<InfoOfTicket> tickets) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.orderSureTime = orderSureTime;
        this.startCityName = startCityName;
        this.endCityName = endCityName;
        this.upAirportName = upAirportName;
        this.downAirportName = downAirportName;
        this.orderState = orderState;
        this.orderContactName = orderContactName;
        this.orderContactTel = orderContactTel;
        this.orderContactEmail = orderContactEmail;
        this.flightsId = flightsId;
        this.orderNums = orderNums;
        this.preUpTime = preUpTime;
        this.preDownTime = preDownTime;
        ModelName = modelName;
        this.flightsMeal = flightsMeal;
        this.tickets = tickets;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Timestamp getOrderSureTime() {
        return orderSureTime;
    }

    public void setOrderSureTime(Timestamp orderSureTime) {
        this.orderSureTime = orderSureTime;
    }

    public String getStartCityName() {
        return startCityName;
    }

    public void setStartCityName(String startCityName) {
        this.startCityName = startCityName;
    }

    public String getEndCityName() {
        return endCityName;
    }

    public void setEndCityName(String endCityName) {
        this.endCityName = endCityName;
    }

    public String getUpAirportName() {
        return upAirportName;
    }

    public void setUpAirportName(String upAirportName) {
        this.upAirportName = upAirportName;
    }

    public String getDownAirportName() {
        return downAirportName;
    }

    public void setDownAirportName(String downAirportName) {
        this.downAirportName = downAirportName;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderContactName() {
        return orderContactName;
    }

    public void setOrderContactName(String orderContactName) {
        this.orderContactName = orderContactName;
    }

    public String getOrderContactTel() {
        return orderContactTel;
    }

    public void setOrderContactTel(String orderContactTel) {
        this.orderContactTel = orderContactTel;
    }

    public String getOrderContactEmail() {
        return orderContactEmail;
    }

    public void setOrderContactEmail(String orderContactEmail) {
        this.orderContactEmail = orderContactEmail;
    }

    public String getFlightsId() {
        return flightsId;
    }

    public void setFlightsId(String flightsId) {
        this.flightsId = flightsId;
    }

    public int getOrderNums() {
        return orderNums;
    }

    public void setOrderNums(int orderNums) {
        this.orderNums = orderNums;
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

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public String getFlightsMeal() {
        return flightsMeal;
    }

    public void setFlightsMeal(String flightsMeal) {
        this.flightsMeal = flightsMeal;
    }

    public List<InfoOfTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<InfoOfTicket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "InfoOfOrder{" +
                "orderId='" + orderId + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderSureTime=" + orderSureTime +
                ", startCityName='" + startCityName + '\'' +
                ", endCityName='" + endCityName + '\'' +
                ", upAirportName='" + upAirportName + '\'' +
                ", downAirportName='" + downAirportName + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderContactName='" + orderContactName + '\'' +
                ", orderContactTel='" + orderContactTel + '\'' +
                ", orderContactEmail='" + orderContactEmail + '\'' +
                ", flightsId='" + flightsId + '\'' +
                ", orderNums=" + orderNums +
                ", preUpTime=" + preUpTime +
                ", preDownTime=" + preDownTime +
                ", ModelName='" + ModelName + '\'' +
                ", flightsMeal='" + flightsMeal + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
