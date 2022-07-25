package com.atguigu.springboot_shiro.server.impl;

import com.atguigu.springboot_shiro.Entity.User;
import com.atguigu.springboot_shiro.mapper.UserMapper;
import com.atguigu.springboot_shiro.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

}
