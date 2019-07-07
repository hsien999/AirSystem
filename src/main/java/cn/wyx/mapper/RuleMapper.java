package cn.wyx.mapper;

        import cn.wyx.entity.Rule;
        import org.apache.ibatis.annotations.Param;

        import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/6 14:31
 * @Version 1.0
 */
public interface RuleMapper {

    /**
     * 添加新的rule
     * @param rule
     */
    void create(Rule rule);

    /**
     * 修改rule
     * @param rule
     */
    void setRule(Rule rule);


    /**
     * 通过舱型编号和退改类型获取退改规则
     * @param spaceId
     * @param ruleType
     * @return
     */
    List<Rule> findBySpaceId(@Param("spaceId") String spaceId, @Param("ruleType") String ruleType);
}
