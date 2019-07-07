package cn.wyx.mapper;

import cn.wyx.entity.Space;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/6 23:57
 * @Version 1.0
 */
public interface SpaceMapper{
    /**chang
     * 创建新的舱型
     * @param space
     */
    void create(Space space);

    /**
     * 设置舱型
     * @param space
     */
    void setSpace(Space space);

    /**
     * 通过Id查询舱型信息
     * @param spaceId
     * @return
     */
    List<Space> findById(String spaceId);

    /**
     * 通过机型Id 由 机型-舱位对应关系 获取相关的舱位对象
     * @param modelId
     * @return
     */
    List<Space> findByRelatedModelId(Long modelId);
}
