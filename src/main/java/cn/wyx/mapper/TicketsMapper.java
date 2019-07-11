package cn.wyx.mapper;

import cn.wyx.entity.Tickets;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: czt
 * @Date: 2019/7/5 17:13
 * @Version 1.0
 */
public interface TicketsMapper {
    /**
     * 通过id查找售票信息
     * @param ticketsId
     * @return
     */
    Tickets findByTicketsId(String ticketsId);

    /**
     * 售票余数减少
     * @param subNum
     * @param ticketsId
     */
    void decreaseTicketsNum(@Param("subNum") int subNum, @Param("ticketsId") String ticketsId);

    /**
     * 创建售票信息
     * @param tickets
     */
    void create(Tickets tickets);

    /**
     * 修改售票的票价和余数
     * @param ticketsId
     * @param ticketsPrice
     * @param ticketsNum
     */
    void setTicketsPriceAndNum(@Param("ticketsId") String ticketsId, @Param("ticketsPrice") int ticketsPrice, @Param("ticketsNum") int ticketsNum);

}
