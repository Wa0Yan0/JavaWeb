package com.example.service;

import com.example.pojo.User;

public interface UserService {

    /**
     * @function 用户注册
     * @param user 类对象
     */
    void register(User user);

    /**
     * @function 登陆
     * @param username
     * @param password
     */
    User login(String username, String password);

    /**
     * @function 判断用户名是否存在
     * @param username
     * @return true存在,false不存在
     */
    boolean existsName(String username);
}
