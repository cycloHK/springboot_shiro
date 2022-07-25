package com.atguigu.springboot_shiro.server;

import com.atguigu.springboot_shiro.Entity.User;


public interface UserService {
    public User queryUserByName(String name);
}
