package cn.wyx.controller;

import cn.wyx.entity.Rule;
import cn.wyx.entity.Space;
import cn.wyx.service.ModelSpaceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wyx
 * @Date: 2019/7/7 20:19
 * @Version 1.0
 */
@RestController
public class ModelSpaceController {
    @Autowired
    private ModelSpaceRuleService service;

    @RequestMapping("findRulesById")
    public List<Rule> findRulesById(@RequestParam(value = "spaceId") String spaceId) {
        try {
            return this.service.findRuleBySpaceId(spaceId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("findBaggageAllowance")
    public int findSpaceById(@RequestParam(value = "spaceId") String spaceId) {
        try {
            Space space = this.service.findSpaceById(spaceId);
            return space == null ? 0 : space.getBaggageAllowance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
