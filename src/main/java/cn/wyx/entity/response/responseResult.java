package cn.wyx.entity.response;

import java.io.Serializable;

/**
 * 封装response
 *
 * @author wyx
 * @date 2019/7/2 17:21
 */
public class responseResult<T> implements Serializable {

    //判断结果
    private boolean success;
    //返回结果信息
    private String msg;
    //返回结果
    private T data;


    public responseResult(boolean success) {
        this.success = success;
    }

    public responseResult(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
