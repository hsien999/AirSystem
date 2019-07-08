package cn.wyx.mapper;

import cn.wyx.entity.InfoOfTickets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/8 14:35
 * @Version 1.0
 */
public interface InfoOfTicketsMapper {

    /**
     * 通过售票Id 或 执飞航班号 或 航舱号 查询所有售票信息
     * @param ticketsId
     * @param flightId
     * @param spaceId
     * @return
     */
    List<InfoOfTickets> findInfoOfTickets(@Param("ticketsId") String ticketsId, @Param("flightId") String flightId,@Param("spaceId") String spaceId);
}
