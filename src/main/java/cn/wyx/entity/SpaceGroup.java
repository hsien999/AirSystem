package cn.wyx.entity;

import java.io.Serializable;

/**
 * @Author: czt
 * @Date: 2019/7/11 20:17
 * @Version 1.0
 */
public class SpaceGroup implements Serializable {
    private Space space;
    private Rule rule1;
    private Rule rule2;
    private Rule rule3;
    private Rule rule4;

    public SpaceGroup() {
    }

    public SpaceGroup(Space space, Rule rule1, Rule rule2, Rule rule3, Rule rule4) {
        this.space = space;
        this.rule1 = rule1;
        this.rule2 = rule2;
        this.rule3 = rule3;
        this.rule4 = rule4;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Rule getRule1() {
        return rule1;
    }

    public void setRule1(Rule rule1) {
        this.rule1 = rule1;
    }

    public Rule getRule2() {
        return rule2;
    }

    public void setRule2(Rule rule2) {
        this.rule2 = rule2;
    }

    public Rule getRule3() {
        return rule3;
    }

    public void setRule3(Rule rule3) {
        this.rule3 = rule3;
    }

    public Rule getRule4() {
        return rule4;
    }

    public void setRule4(Rule rule4) {
        this.rule4 = rule4;
    }

    @Override
    public String toString() {
        return "spaceGroup{" +
                "space=" + space +
                ", rule1=" + rule1 +
                ", rule2=" + rule2 +
                ", rule3=" + rule3 +
                ", rule4=" + rule4 +
                '}';
    }
}
