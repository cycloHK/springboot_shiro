package com.atguigu.springboot_shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getshiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
        * anon :无需认证就能访问
        * authc：必须认证才能访问
        * user：必须拥有 记住我 功能才能访问
        * perms：拥有对某个资源的权限才能访问
        * role 拥有某个角色权限才能访问
        * */

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        //登录认证
        //设置权限
        filterMap.put("/user/*","authc");

        bean.setFilterChainDefinitionMap(filterMap);


        //设置登录页面
        bean.setLoginUrl("/tologin");
        //设置未授权页面
        bean.setUnauthorizedUrl("/unauthorized");
        return bean;
    }


    //DafaultWebSecurityManager2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm 对象 需要自定义类 1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
