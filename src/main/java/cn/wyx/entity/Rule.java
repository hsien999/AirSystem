package cn.wyx.entity;

import java.io.Serializable;

/**
 *退改规则
 */
public class Rule implements Serializable {
    private Long ruleId;
    /**
     *舱位编号
     */
    private String spaceId;
    /**
     *退改类型
     */
    private String ruleType;
    /**
     *退票手续费率
     */
    private int ruleRefund;
    /**
     *改票手续费率
     */
    private int ruleChange;

    public Rule() {
    }

    public Rule(Long ruleId, String spaceId, String ruleType, int ruleRefund, int ruleChange) {
        this.ruleId = ruleId;
        this.spaceId = spaceId;
        this.ruleType = ruleType;
        this.ruleRefund = ruleRefund;
        this.ruleChange = ruleChange;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public int getRuleRefund() {
        return ruleRefund;
    }

    public void setRuleRefund(int ruleRefund) {
        this.ruleRefund = ruleRefund;
    }

    public int getRuleChange() {
        return ruleChange;
    }

    public void setRuleChange(int ruleChange) {
        this.ruleChange = ruleChange;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleId=" + ruleId +
                ", spaceId='" + spaceId + '\'' +
                ", ruleType='" + ruleType + '\'' +
                ", ruleRefund=" + ruleRefund +
                ", ruleChange=" + ruleChange +
                '}';
    }
}
