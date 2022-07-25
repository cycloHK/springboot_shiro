package com.atguigu.springboot_shiro.mapper;

import com.atguigu.springboot_shiro.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public User queryUserByName(String name);
}
