package cn.wyx.entity;

import java.io.Serializable;

/**
 * @Author: wyx
 * @Date: 2019/7/2 17:21
 * @Version 1.0
 */
public class Result implements Serializable {

    //判断结果
    private boolean success;
    //返回信息
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
