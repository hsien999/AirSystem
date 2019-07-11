package cn.wyx.service.impl;

import cn.wyx.entity.Mdsp;
import cn.wyx.entity.Model;
import cn.wyx.entity.Rule;
import cn.wyx.entity.Space;
import cn.wyx.mapper.MdspMapper;
import cn.wyx.mapper.ModelMapper;
import cn.wyx.mapper.RuleMapper;
import cn.wyx.mapper.SpaceMapper;
import cn.wyx.service.ModelSpaceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author: czt
 * @Date: 2019/7/7 11:06
 * @Version 1.0
 */
@Service
public class ModelSpaceRuleServiceIml implements ModelSpaceRuleService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SpaceMapper spaceMapper;
    @Autowired
    private MdspMapper mdspMapper;
    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public void createRule(Rule rule) {
        this.ruleMapper.create(rule);
    }

    @Override
    public void setRule(Rule rule) {
        this.ruleMapper.setRule(rule);
    }

    @Override
    public List<Rule> findRuleBySpaceId(String spaceId) {
        return this.ruleMapper.findBySpaceId(spaceId,null);
    }

    @Override
    public Rule findRuleBySpaceIdAndRuleType(String spaceId, String ruleType) {
        List<Rule> rules = this.ruleMapper.findBySpaceId(spaceId,ruleType);
        if(rules != null && rules.size() > 0)
            return rules.get(0);
        return null;
    }

    @Override
    public void createModel(Model model) {
        this.modelMapper.create(model);
    }

    @Override
    public void setModel(Model model) {
        this.modelMapper.setModel(model);
    }

    @Override
    public Model findModelByModelId(Long modelId) {
        List<Model> models = this.modelMapper.findModel(modelId,null);
        if(models != null && models.size()>0)
            return models.get(0);
        return null;
    }

    @Override
    public Model findModelByModelName(String modelName) {
        List<Model> models = this.modelMapper.findModel(null,modelName);
        if(models != null && models.size()>0)
            return models.get(0);
        return null;
    }

    @Override
    public List<Model> findAllModel() {
        return this.modelMapper.findModel(null,null);
    }

    @Override
    public void createSpace(Space space) {
        this.spaceMapper.create(space);
    }

    @Override
    public void setSpace(Space space) {
        this.spaceMapper.setSpace(space);
    }

    @Override
    public Space findSpaceById(String spaceId) {
        Space space = this.spaceMapper.findById(spaceId);
        return space;
    }

    @Override
    public List<Space> findSpaceByRelatedModelId(Long modelId) {
        return this.spaceMapper.findByRelatedModelId(modelId);
    }

    @Override
    public List<Space> findAllSpace() {
        return this.spaceMapper.findAllSpace();
    }

    @Override
    public void createMdsp(Mdsp mdsp) {
        this.mdspMapper.create(mdsp);
    }

    @Override
    public void setMdspNums(Mdsp mdsp) {
        this.mdspMapper.setNums(mdsp);
    }

    @Override
    public List<Mdsp> findMdsp(Long modelId, String spaceId) {
        return this.mdspMapper.findMdsp(modelId,spaceId);
    }

    @Override
    public void deleteMdsp(Long modelId, String spaceId) {
        this.mdspMapper.delete(modelId,spaceId);
    }
}
