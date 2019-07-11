package cn.wyx.mapper;

import cn.wyx.entity.Model;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/6 15:54
 * @Version 1.0
 */
public interface ModelMapper {
    /**
     *  添加机型
     * @param model
     */
    void create(Model model);

    /**
     * 修改机型
     * @param model
     */
    void setModel(Model model);

    /**
     * 获取机型
     * @param modelId
     * @param modelName
     * @return
     */
    List<Model> findModel(@Param("modelId") Long modelId, @Param("modelName") String modelName);
}
