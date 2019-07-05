import cn.wyx.entity.UserPass;
import cn.wyx.service.UserPassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 11:23
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestUserPass {
    @Autowired
    private UserPassService userPassService;

    @Test
    public void create()
    {
        UserPass userPass = new UserPass(1L,1L,"蔡志涛","360600000000000000","身份证","18106932995","成人");
        UserPass userPass2 = new UserPass(1L,1L,"王永贤","360600000000000001","身份证","18107017785","成人");
        this.userPassService.create(userPass2);
    }
    @Test
    public void select()
    {
        UserPass userPass = this.userPassService.findById(2L);
        System.out.println(userPass);
    }
    @Test
    public void selectAll()
    {
        List<UserPass> userPasses = this.userPassService.findAllById(1L);
        System.out.println(userPasses);
    }

    @Test
    public void update()
    {
        UserPass userPass = new UserPass(2L,1L,"蔡志涛66","360600000000000001","身份证","18106932995","成人");
        this.userPassService.update(userPass);
    }

    @Test
    public void delete()
    {
        this.userPassService.delete(2L);
    }
}
