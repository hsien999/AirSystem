package cn.wyx.controller.authentication;

import cn.wyx.entity.Result;
import cn.wyx.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wyx
 * @Date: 2019/7/8 16:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/security")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @RequestMapping("/authentication")
    public Result authentication() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null || subject.getPrincipal() == null || (!subject.isAuthenticated() && !subject.isRemembered()))
            return new Result(false, null);
        try {
            String userName = (String) subject.getPrincipal();
            //找到对应的userid
            Long userId = this.userService.findByTel(userName).getUserId();
            String name = this.userService.getChName(userId);
            return new Result(true, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, null);
    }
}
