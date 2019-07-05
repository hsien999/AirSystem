package cn.wyx.service.impl;

import cn.wyx.entity.UserPass;
import cn.wyx.mapper.UserPassMapper;
import cn.wyx.service.UserPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: czt
 * @Date: 2019/7/5 11:10
 * @Version 1.0
 */
@Service
public class UserPassServiceIml implements UserPassService {
    @Autowired
    UserPassMapper userPassMapper;


    @Override
    public List<UserPass> findAllById(Long userId) {
         return userPassMapper.findAllByUserId(userId);
    }

    @Override
    public List<UserPass> findAll() {
        return null;
    }

    @Override
    public UserPass findById(Long id) {
        return userPassMapper.findOneByUserPassId(id);
    }

    @Override
    public UserPass findById(String id) {
        return null;
    }

    @Override
    public void create(UserPass userPass) {
        userPassMapper.insert(userPass);
    }

    @Override
    public void update(UserPass userPass) {
        userPassMapper.update(userPass);
    }

    @Override
    public void delete(Long... ids) {
       for(Long id:ids){
           this.userPassMapper.delete(id);
       }
    }

    @Override
    public void delete(String... ids) {

    }
}
