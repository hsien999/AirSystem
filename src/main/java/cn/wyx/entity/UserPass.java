package cn.wyx.entity;

import java.io.Serializable;

/**
 *常用乘机人
 */
public class UserPass implements Serializable {
    /**
     *常用乘机人编号
     */
    private Long userpassId;
    /**
     *用户编号
     */
    private Long userId;
    /**
     *乘机人姓名
     */
    private String userpassName;
    /**
     *乘机人证件号
     */
    private String userpassCerid;
    /**
     *乘机人证件类型
     */
    private String userpassCertype;
    /**
     *乘机人手机号
     */
    private String userpassTel;
    /**
     *乘机人类型
     */
    private String userpassType;

    public UserPass() {
    }

    public UserPass(Long userpassId, Long userId, String userpassName, String userpassCerid, String userpassCertype, String userpassTel, String userpassType) {
        this.userpassId = userpassId;
        this.userId = userId;
        this.userpassName = userpassName;
        this.userpassCerid = userpassCerid;
        this.userpassCertype = userpassCertype;
        this.userpassTel = userpassTel;
        this.userpassType = userpassType;
    }

    public Long getUserpassId() {
        return userpassId;
    }

    public void setUserpassId(Long userpassId) {
        this.userpassId = userpassId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserpassName() {
        return userpassName;
    }

    public void setUserpassName(String userpassName) {
        this.userpassName = userpassName;
    }

    public String getUserpassCerid() {
        return userpassCerid;
    }

    public void setUserpassCerid(String userpassCerid) {
        this.userpassCerid = userpassCerid;
    }

    public String getUserpassCertype() {
        return userpassCertype;
    }

    public void setUserpassCertype(String userpassCertype) {
        this.userpassCertype = userpassCertype;
    }

    public String getUserpassTel() {
        return userpassTel;
    }

    public void setUserpassTel(String userpassTel) {
        this.userpassTel = userpassTel;
    }

    public String getUserpassType() {
        return userpassType;
    }

    public void setUserpassType(String userpassType) {
        this.userpassType = userpassType;
    }

    @Override
    public String toString() {
        return "UserPass{" +
                "userpassId=" + userpassId +
                ", userId=" + userId +
                ", userpassName='" + userpassName + '\'' +
                ", userpassCerid='" + userpassCerid + '\'' +
                ", userpassCertype='" + userpassCertype + '\'' +
                ", userpassTel='" + userpassTel + '\'' +
                ", userpassType='" + userpassType + '\'' +
                '}';
    }
}
