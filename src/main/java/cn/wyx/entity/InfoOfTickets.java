package cn.wyx.entity;

import java.io.Serializable;

/**
 *订票查询显示的机票的信息
 */
public class InfoOfTickets implements Serializable {
    /**
     * 舱型编号
     */
    private char spaceId;
    /**
     * 售票编号
     */
    private String ticketsId;
    /**
     *舱型名称
     */
    private String spaceName;
    /**
     *售票价格
     */
    private int ticketsPrice;
    /**
     *售票余数
     */
    private int ticketsNums;
    /**
     * 售票总数
     */
    private int ticketsAllNums;

    public InfoOfTickets() {
    }

    public InfoOfTickets(char spaceId, String ticketsId, String spaceName, int ticketsPrice, int ticketsNums, int ticketsAllNums) {
        this.spaceId = spaceId;
        this.ticketsId = ticketsId;
        this.spaceName = spaceName;
        this.ticketsPrice = ticketsPrice;
        this.ticketsNums = ticketsNums;
        this.ticketsAllNums = ticketsAllNums;
    }

    public char getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(char spaceId) {
        this.spaceId = spaceId;
    }

    public String getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(String ticketsId) {
        this.ticketsId = ticketsId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
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

    public int getTicketsAllNums() {
        return ticketsAllNums;
    }

    public void setTicketsAllNums(int ticketsAllNums) {
        this.ticketsAllNums = ticketsAllNums;
    }

    @Override
    public String toString() {
        return "InfoOfTickets{" +
                "spaceId=" + spaceId +
                ", ticketsId='" + ticketsId + '\'' +
                ", spaceName='" + spaceName + '\'' +
                ", ticketsPrice=" + ticketsPrice +
                ", ticketsNums=" + ticketsNums +
                ", ticketsAllNums=" + ticketsAllNums +
                '}';
    }
}
