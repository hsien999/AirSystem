package cn.wyx.mapper;

import cn.wyx.entity.Tickets;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: czt
 * @Date: 2019/7/5 17:13
 * @Version 1.0
 */
public interface TicketsMapper {

    Tickets findByTicketsId(String ticketsId);

    void decreaseTicketsNum(@Param("subNum") int subNum,@Param("ticketsId") String ticketsId);
}
