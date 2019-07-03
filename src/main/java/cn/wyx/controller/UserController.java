package cn.wyx.controller;

import cn.wyx.entity.Result;
import cn.wyx.entity.User;
import cn.wyx.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Scanner;

/**
 * @Author: wyx
 * @Date: 2019/7/2 17:21
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录的入口
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Result login(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "remember", required = false) String remember) {

        System.out.println("登陆用户输入的用户名：" + username + "，密码：" + password);
        String error = null;
        if (username != null && password != null) {
            //初始化
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            if (remember != null) {
                if (remember.equals("true")) {
                    //说明选择了记住我
                    token.setRememberMe(true);
                } else {
                    token.setRememberMe(false);
                }
            } else {
                token.setRememberMe(false);
            }

            try {
                //登录，即身份校验，由通过Spring注入的UserRealm会自动校验输入的用户名和密码在数据库中是否有对应的值
                subject.login(token);
                System.out.println("用户是否登录：" + subject.isAuthenticated());
                return new Result(true, "success");
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                error = "用户账户不存在!";
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                error = "用户名或密码错误!";
            } catch (LockedAccountException e) {
                e.printStackTrace();
                error = "该账号已锁定!";
            } catch (DisabledAccountException e) {
                e.printStackTrace();
                error = "该账号已禁用!";
            } catch (ExcessiveAttemptsException e) {
                e.printStackTrace();
                error = "该账号登录失败次数过多!";
            } catch (Exception e) {
                e.printStackTrace();
                error = "未知错误!";
            }
        } else {
            error = "请输入用户名和密码";
        }
        //登录失败
        return new Result(false, error);
    }

    /**
     * 注册接口
     *
     * @param user
     * @return
     */
    @RequestMapping("register.do")
    public Result Register(@RequestBody User user) {
        boolean success = false;
        String message = "error";
        try {
            this.userService.create(user);
            success = true;
            message = "注册成功";
        } catch (Exception e) {
            success = true;
            message = "出现错误,注册失败";
            e.printStackTrace();
        }
        return new Result(success, message);
    }

    /**
     * 手机号校验接口
     *
     * @param tel
     * @return
     */
    @RequestMapping("validateTel.do")
    public Result validateTel(@RequestParam(value = "tel") String tel) {
        boolean success = false;
        String message = "error";
        try {
            if (this.userService.validateTel(tel)) {
                success = true;
                message = "校验成功";
            } else {
                success = false;
                message = "该手机号已存在";
            }
        } catch (Exception e) {
            success = false;
            message = "未知错误";
            e.printStackTrace();
        }
        return new Result(success, message);
    }

    /**
     * 证件号校验接口
     *
     * @param cerId
     * @return
     */
    @RequestMapping("validateCerId.do")
    public Result validateCerId(@RequestParam(value = "cerId") String cerId) {
        try {
            if (this.userService.validateCerId(cerId)) {
                return new Result(true, "校验成功");
            } else {
                return new Result(false, "该手机号已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "未知错误");
    }

    /**
     * 退出登录==>Shiro的Filter过滤器会帮我们生成一个logout请求，
     * 当浏览器访问`/logout`请求时，Shiro会自动清空缓存并重定向到配置好的loginUrl页面
     *
     * @return
     */
    @RequestMapping("/logout")
    public void logout(ModelAndView md) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("-----------登出------------");
    }

}
