package cn.wyx.service.impl;

import cn.wyx.entity.User;
import cn.wyx.mapper.UserMapper;
import cn.wyx.service.PasswordHelper;
import cn.wyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wyx
 * @Date: 2019/7/3 17:28
 * @Version 1.0
 */
@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public User findByTel(String tel) {
        return this.userMapper.findByTel(tel);
    }

    /**
     * 修改密码，重新加密后再更新
     *
     * @param id          用户主码
     * @param newPassword 新密码
     */
    @Override
    public void changePassword(Long id, String newPassword) {
        User user = userMapper.findById(id);
        user.setUserPass(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.update(user);
    }

    /**
     * 创建用户
     *
     * @param user
     */
    @Override
    public void create(User user) {
        /**
         * 不存在相同的证件号或手机号
         */
        if (validateTel(user.getUserTel()) && validateCerId(user.getUserCerid())) {
            passwordHelper.encryptPassword(user);
            this.userMapper.create(user);
        }
    }

    @Override
    public Long getId(String userTel) {
        return this.userMapper.getId(userTel);
    }

    @Override
    public String getChName(Long id) {
        return this.userMapper.getChName(id);
    }

    /**
     * 更新用户信息
     */
    @Override
    public void update(User user) {
        passwordHelper.encryptPassword(user);
        this.userMapper.update(user);
    }

    /**
     * 删除用户信息
     */
    @Override
    public void delete(Long... ids) {
        for (Long id : ids) {
            this.userMapper.delete(id);
        }
    }

    /**
     * 验证是否存在相同的手机号/证件号
     */

    @Override
    public boolean validateTel(String tel) {
        return this.userMapper.validateTel(tel) == 0;
    }

    @Override
    public boolean validateCerId(String CerId) {
        return this.userMapper.validateCerId(CerId) == 0;
    }

    @Override
    public List<User> findAll() {
        return this.userMapper.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userMapper.findById(id);
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public void delete(String... ids) {

    }
}
