package com.show.service.Impl;

import com.show.dao.UserMapper;
import com.show.model.User;
import com.show.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Show on 2018/7/25.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public User getUserByNamePass(User user) {
        return userMapper.getUserByNamePass(user);
    }

    public User getUserByName(User user) {
        return userMapper.getUserByName(user);
    }
}
