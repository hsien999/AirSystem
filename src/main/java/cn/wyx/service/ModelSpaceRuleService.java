package cn.wyx.service;
import cn.wyx.entity.Mdsp;
import cn.wyx.entity.Model;
import cn.wyx.entity.Rule;
import cn.wyx.entity.Space;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/7 10:06
 * @Version 1.0
 */
public interface ModelSpaceRuleService {
    /**
     * 建立机型
     * @param model
     */
    void createModel(Model model);

    /**
     * 设置机型
     * @param model
     */
    void setModel(Model model);

    /**
     * 通过Id查找机型
     * @param modelId
     * @return
     */
    Model findModelByModelId(Long modelId);

    /**
     * 通过机型名称查找机型对象
     * @param modelName
     * @return
     */
    Model findModelByModelName(String modelName);

    /**
     * 查询所有机型
     * @return
     */
    List<Model> findAllModel();

    /**
     * 新建舱位
     * @param space
     */
    void createSpace(Space space);

    /**
     * 设置舱位
     * @param space
     */
    void setSpace(Space space);

    /**
     * 通过id查询舱位信息
     * @param spaceId
     * @return
     */
    Space findSpaceById(String spaceId);

    /**
     * 通过机型Id 由 机型-舱位对应关系 获取相关的舱位对象
     * @param modelId
     * @return
     */
    List<Space> findSpaceByRelatedModelId(Long modelId);
    /**
     * 获取所有舱位信息
     * @return
     */
    List<Space> findAllSpace();

    /**
     * 新建机型-舱位对应关系
     * @param mdsp
     */
    void createMdsp(Mdsp mdsp);

    /**
     * 删除对应关系
     * @param modelId
     * @param spaceId
     */
    void deleteMdsp(Long modelId, String spaceId);

    /**
     * 设置机型-舱位对应的座位数
     * @param mdsp
     */
    void setMdspNums(Mdsp mdsp);

    /**
     * 通过 机型Id 或 舱位Id 查询 机型-舱位对应关系
     * 或 查询所有 机型-舱位对应关系
     * @param modelId
     * @param spaceId
     * @return
     */
    List<Mdsp> findMdsp(Long modelId, String spaceId);

    /**
     * 创建新的退改规则
     * @param rule
     */
    void createRule(Rule rule);

    /**
     * 修改退改规则
     * @param rule
     */
    void setRule(Rule rule);

    /**
     * 查询某一舱型的所有退改规则
     * @param spaceId
     * @return
     */
    List<Rule> findRuleBySpaceId(String spaceId);

    /**
     * 通过机型和退改类型获取某一退改规则
     * @param spaceId
     * @param ruleType
     * @return
     */
    Rule findRuleBySpaceIdAndRuleType(String spaceId, String ruleType);
}
