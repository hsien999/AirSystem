import cn.wyx.entity.Mdsp;
import cn.wyx.entity.Model;
import cn.wyx.entity.Rule;
import cn.wyx.entity.Space;
import cn.wyx.service.ModelSpaceRuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/7 15:24
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestModelSpaceRule {
    @Autowired
    private ModelSpaceRuleService modelSpaceRuleService;

    @Test
    public void creaet()
    {
        Model model = new Model(1L,"C919",700);
        Space space = new Space("Y","头等舱",70,1.5);
        Rule rule = new Rule(1L,"Y","7",30,30);
        Mdsp mdsp = new Mdsp(1L,"Y",20);

        this.modelSpaceRuleService.createModel(model);
        this.modelSpaceRuleService.createSpace(space);
        this.modelSpaceRuleService.createRule(rule);
        this.modelSpaceRuleService.createMdsp(mdsp);
    }

    @Test
    public void set()
    {
        Model model = new Model(1L,"空客747",650);
        Space space = new Space("Y","经济舱",50,1);
        Rule rule = new Rule(1L,"Y","3",10,10);
        Mdsp mdsp = new Mdsp(1L,"Y",60);

        this.modelSpaceRuleService.setModel(model);
        this.modelSpaceRuleService.setSpace(space);
        this.modelSpaceRuleService.setRule(rule);
        this.modelSpaceRuleService.setMdspNums(mdsp);
    }

    @Test
    public void select()
    {
        List<Model> models = this.modelSpaceRuleService.findAllModel();
        System.out.println(models);

        List<Space> spaces =  this.modelSpaceRuleService.findAllSpace();
        System.out.println(spaces);

        Model model =  this.modelSpaceRuleService.findModelByModelId(1L);
        System.out.println(model);

        List<Space> spaces2 = this.modelSpaceRuleService.findSpaceByRelatedModelId(1L);
        System.out.println(spaces2);

        List<Mdsp> mdsps = this.modelSpaceRuleService.findMdsp(1L,null);
        System.out.println(mdsps);

        mdsps = this.modelSpaceRuleService.findMdsp(1L,"Y");
        System.out.println(mdsps);

        Space space =  this.modelSpaceRuleService.findSpaceById("Y");
        System.out.println(space);

        Model model1 = this.modelSpaceRuleService.findModelByModelName("空客747");
        System.out.println(model1);

        List<Rule> rules = this.modelSpaceRuleService.findRuleBySpaceId("Y");
        System.out.println(rules);

        Rule rule = this.modelSpaceRuleService.findRuleBySpaceIdAndRuleType("Y","3");
        System.out.println(rule);
    }
}
