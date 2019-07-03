package cn.wyx.entity;

import java.io.Serializable;

/**
 *退改规则
 */
public class Rule implements Serializable {
    /**
     *舱位编号
     */
    private char spaceId;
    /**
     *退改类型
     */
    private char ruleType;
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

    public Rule(char spaceId, char ruleType, int ruleRefund, int ruleChange) {
        this.spaceId = spaceId;
        this.ruleType = ruleType;
        this.ruleRefund = ruleRefund;
        this.ruleChange = ruleChange;
    }

    public char getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(char spaceId) {
        this.spaceId = spaceId;
    }

    public char getRuleType() {
        return ruleType;
    }

    public void setRuleType(char ruleType) {
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
                "spaceId=" + spaceId +
                ", ruleType=" + ruleType +
                ", ruleRefund=" + ruleRefund +
                ", ruleChange=" + ruleChange +
                '}';
    }
}
