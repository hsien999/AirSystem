package cn.wyx.mapper;

import cn.wyx.entity.Mdsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/6 16:28
 * @Version 1.0
 */
public interface MdspMapper {
    /**
     * 添加舱位-机型对应的总座位数
     * @param mdsp
     */
    void create(Mdsp mdsp);

    /**
     * 修改舱位—机型对应的总座位数
     * @param mdsp
     */
    void setNums(Mdsp mdsp);

    /**
     * 获取机型—舱位对应的总座位数
     * @param modelId
     * @param spaceId
     * @return
     */
    List<Mdsp> findMdsp(@Param("modelId") Long modelId, @Param("spaceId") String spaceId);

    /**
     * 删除机型航舱对应
     * @param modelId
     * @param spaceId
     */
    void delete(@Param("modelId") Long modelId, @Param("spaceId") String spaceId);
}
