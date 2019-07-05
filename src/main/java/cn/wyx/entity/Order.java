package cn.wyx.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *订单
 */
public class Order implements Serializable {
    /**
     *订单编号
     */
    private String orderId;
    /**
     *用户编号
     */
    private Long userId;
    /**
     *价格
     */
    private int orderPrice;
    /**
     *确认时间
     */
    private Timestamp orderSureTime;
    /**
     *支付时间
     */
    private Timestamp orderPayTime;
    /**
     *支付方式
     */
    private String orderPayType;
    /**
     *乘客人数量
     */
    private int orderNums;
    /**
     *订单状态
     */
    private String orderState;
    /**
     *联系人姓名
     */
    private String orderContactName;
    /**
     *联系人手机号
     */
    private String orderContactTel;
    /**
     *联系人邮箱
     */
    private String ordercontactEmail;

    public Order() {
    }

    public Order(String orderId, Long userId, int orderPrice, Timestamp orderSureTime, Timestamp orderPayTime, String orderPayType, int orderNums, String orderState, String orderContactName, String orderContactTel, String ordercontactEmail) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.orderSureTime = orderSureTime;
        this.orderPayTime = orderPayTime;
        this.orderPayType = orderPayType;
        this.orderNums = orderNums;
        this.orderState = orderState;
        this.orderContactName = orderContactName;
        this.orderContactTel = orderContactTel;
        this.ordercontactEmail = ordercontactEmail;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Timestamp getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Timestamp orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public String getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(String orderPayType) {
        this.orderPayType = orderPayType;
    }

    public int getOrderNums() {
        return orderNums;
    }

    public void setOrderNums(int orderNums) {
        this.orderNums = orderNums;
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

    public String getOrdercontactEmail() {
        return ordercontactEmail;
    }

    public void setOrdercontactEmail(String ordercontactEmail) {
        this.ordercontactEmail = ordercontactEmail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", orderPrice=" + orderPrice +
                ", orderSureTime=" + orderSureTime +
                ", orderPayTime=" + orderPayTime +
                ", orderPayType='" + orderPayType + '\'' +
                ", orderNums=" + orderNums +
                ", orderState='" + orderState + '\'' +
                ", orderContactName='" + orderContactName + '\'' +
                ", orderContactTel='" + orderContactTel + '\'' +
                ", ordercontactEmail='" + ordercontactEmail + '\'' +
                '}';
    }
}
