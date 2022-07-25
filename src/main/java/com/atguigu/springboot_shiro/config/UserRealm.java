package com.atguigu.springboot_shiro.config;

import com.atguigu.springboot_shiro.Entity.User;
import com.atguigu.springboot_shiro.server.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User curUser = (User)subject.getPrincipal();//取出user
        //设置当前用户的权限
        info.addStringPermission(curUser.getPerms());

        return info;

    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");
        //用户名和 密码
        //连接真实的数据
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        User user = userService.queryUserByName(usertoken.getUsername());
        if (user == null){
            return null;//抛出异常
        }
        return new SimpleAccount(user,user.getPwd(),"");//一个简单的账户


    }
}
