package cn.wyx.mapper;

import cn.wyx.entity.Ticket;

/**
 * @Author: czt
 * @Date: 2019/7/5 14:26
 * @Version 1.0
 */
public interface TicketMapper {
    /**
     * 添加机票
     * @param ticket
     * @return
     */
    int insertTicket(Ticket ticket);

}
