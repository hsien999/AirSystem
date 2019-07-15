package cn.wyx.service;

import cn.wyx.entity.User;

/**
 * 用户业务逻辑接口
 *
 * @Author: wyx
 * @Date: 2019/7/3 16:56
 * @Version 1.0
 */
public interface UserService extends BaseService<User> {
    /**
     * 获取用户
     */
    User findByTel(String tel);

    /**
     * 修改密码
     */
    void changePassword(Long id, String newPassword);

    /**
     * 验证手机号是否已经存在
     */

    boolean validateTel(String tel);

    /**
     * 验证该证件号是否存在
     */
    boolean validateCerId(String CerId);

    String getChName(Long id);

    Long getId(String userTel);
}
