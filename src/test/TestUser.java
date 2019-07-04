import cn.wyx.entity.User;
import cn.wyx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: wyx
 * @Date: 2019/7/3 10:12
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*.xml"})
public class TestUser {

    @Autowired
    private UserService userService;

    @Test
    public void create() {
        User user = new User(1L, "13774831008", "123", "身份证", "王永贤", "wyx", "123", "123");
        this.userService.create(user);
    }

    @Test
    public void find() {
        User user = this.userService.findByTel("13774831008");
        System.out.println("pass=" + user.getUserPass());
        user = this.userService.findById(1L);
        System.out.println("pass=" + user.getUserPass());

    }

    @Test
    public void changePass() {
        this.userService.changePassword(1L, "123");
        System.out.println("pass=" + this.userService.findById(1L));
    }

    @Test
    public void update() {
        User user = this.userService.findById(1L);
        user.setUserEnname("wyx");
        this.userService.update(user);
    }

    @Test
    public void validate() {
        System.out.println(this.userService.validateTel("13774831008"));
        System.out.println(this.userService.validateCerId("123"));
    }

}
