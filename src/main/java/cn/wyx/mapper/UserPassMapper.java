package cn.wyx.mapper;

import cn.wyx.entity.UserPass;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 10:27
 * @Version 1.0
 */
public interface UserPassMapper {
    /**
     * 添加常用乘机人
     * @param userPass
     * @return
     */
    int insert(UserPass userPass);

    /**
     * 删除常用乘机人
     * @param userPassId
     * @return
     */
    int delete(Long userPassId);

    /**
     * 更新常用乘机人
     * @param userPass
     * @return
     */
    int update(UserPass userPass);

    /**
     * 获取所有用户所有常用乘机人
     * @param userId
     * @return
     */
    List<UserPass> findAllByUserId(Long userId);

    /**
     * 获取某一乘机人信息
     * @param userPassId
     * @return
     */
    UserPass findOneByUserPassId(Long userPassId);
}
