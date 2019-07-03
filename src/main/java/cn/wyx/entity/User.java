package cn.wyx.entity;


import java.io.Serializable;


/**
 * 用户
 */
public class User implements Serializable {
    /**
     *用户编号
     */
    private Long userId;
    /**
     *手机号
     */
    private String userTel;
    /**
     *证件号
     */
    private String userCerid;
    /**
     *证件类型
     */
    private String userCerType;
    /**
     *中文名
     */
    private String userChname;
    /**
     *英文名
     */
    private String userEnname;
    /**
     *盐值
     */
    private String userSalt;
    /**
     *密码
     */
    private String userPass;

    public User() {
    }

    public User(Long userId, String userTel, String userCerid, String userCerType, String userChname, String userEnname, String userSalt, String userPass) {
        this.userId = userId;
        this.userTel = userTel;
        this.userCerid = userCerid;
        this.userCerType = userCerType;
        this.userChname = userChname;
        this.userEnname = userEnname;
        this.userSalt = userSalt;
        this.userPass = userPass;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserCerid() {
        return userCerid;
    }

    public void setUserCerid(String userCerid) {
        this.userCerid = userCerid;
    }

    public String getUserCerType() {
        return userCerType;
    }

    public void setUserCerType(String userCerType) {
        this.userCerType = userCerType;
    }

    public String getUserChname() {
        return userChname;
    }

    public void setUserChname(String userChname) {
        this.userChname = userChname;
    }

    public String getUserEnname() {
        return userEnname;
    }

    public void setUserEnname(String userEnname) {
        this.userEnname = userEnname;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getCredentialsSalt() {
        return userTel + userSalt;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userTel='" + userTel + '\'' +
                ", userCerid='" + userCerid + '\'' +
                ", userCerType='" + userCerType + '\'' +
                ", userChname='" + userChname + '\'' +
                ", userEnname='" + userEnname + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
