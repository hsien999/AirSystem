package cn.wyx.mapper;

import cn.wyx.entity.User;

/**
 * @Author: wyx
 * @Date: 2019/7/2 17:21
 * @Version 1.0
 */
public interface UserMapper {

    User findByName(String username);

    User findById(Long id);

    void update(User user);

    void create(User user);

    void delete(Long id);
}
