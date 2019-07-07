package cn.wyx.entity;

import java.io.Serializable;

/**
 *舱位
 */
public class Space implements Serializable {
    /**
     *舱位编号
     */
    private String spaceId;
    /**
     *舱位名称
     */
    private String spaceName;
    /**
     *行李限额
     */
    private int baggageAllowance;
    /**
     * 舱位折扣
     */
    private double spaceDiscount;

    public Space() {
    }

    public Space(String spaceId, String spaceName, int baggageAllowance, double spaceDiscount) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.baggageAllowance = baggageAllowance;
        this.spaceDiscount = spaceDiscount;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public int getBaggageAllowance() {
        return baggageAllowance;
    }

    public void setBaggageAllowance(int baggageAllowance) {
        this.baggageAllowance = baggageAllowance;
    }

    public double getSpaceDiscount() {
        return spaceDiscount;
    }

    public void setSpaceDiscount(double spaceDiscount) {
        this.spaceDiscount = spaceDiscount;
    }

    @Override
    public String toString() {
        return "Space{" +
                "spaceId='" + spaceId + '\'' +
                ", spaceName='" + spaceName + '\'' +
                ", baggageAllowance=" + baggageAllowance +
                ", spaceDiscount=" + spaceDiscount +
                '}';
    }
}
