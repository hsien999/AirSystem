package cn.wyx.mapper;

import cn.wyx.entity.User;

import java.util.List;

/**
 * @Author: wyx
 * @Date: 2019/7/3 16:04
 * @Version 1.0
 */
public interface UserMapper {
    /**
     * 查找所有用户
     */
    List<User> findAll();

    /**
     * 根据手机号码查询
     */

    User findByTel(String tel);

    /**
     * 根据id查询
     */
    User findById(Long id);

    /**
     * 创建用户
     */
    void create(User user);

    /**
     * 更新用户
     */
    void update(User user);

    /**
     * 删除用户
     */
    void delete(Long id);

    /**
     * 验证是否存在该手机号
     */
    int validateTel(String tel);

    /**
     * 验证是否存在该证件号
     */
    int validateCerId(String CerId);
}
