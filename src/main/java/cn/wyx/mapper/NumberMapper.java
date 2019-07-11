package cn.wyx.mapper;

/**
 * @Author: czt
 * @Date: 2019/7/5 19:32
 * @Version 1.0
 */
public interface NumberMapper {
    /**
     * 机票id依赖数字递增
     */
    void increaseTicketRelyOnNumber();

    /**
     * 获取机票id依赖数字
     * @return Long
     */
    long getTicketRelyOnNumber();

    /**
     * 设置机票id依赖数字为0
     */
    void setTicketRelyOnNumberZero();

}
