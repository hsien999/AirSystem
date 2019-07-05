package cn.wyx.service;

import cn.wyx.entity.UserPass;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 11:05
 * @Version 1.0
 */
public interface UserPassService extends BaseService<UserPass> {
    /**
     * 查询某用户所有常用乘机人
     * @param userId
     * @return
     */
    List<UserPass> findAllById(Long userId);
}
