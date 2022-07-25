package com.atguigu.springboot_shiro;

import com.atguigu.springboot_shiro.server.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("root"));
System.out.println(userService.queryUserByName("root"));
    }


}
