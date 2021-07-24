package com.wayan.service.impl;

import com.wayan.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserServiceImpl userService = new UserServiceImpl();
    @Test
    public void register() {
        userService.register(new User("sunli","000","sunli@gmail.com"));
    }

    @Test
    public void login() {
        User waYan = userService.login("wayan", "123");
        System.out.println(waYan);
    }

    @Test
    public void existsName() {
        if(userService.existsName("wayan1")==true){
            System.out.println("用户名已存在！！！");
        }else{
            System.out.println("用户名可用");
        }
    }
}