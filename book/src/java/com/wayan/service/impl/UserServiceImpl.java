package com.wayan.service.impl;

import com.wayan.dao.impl.UserDaoImpl;
import com.wayan.pojo.User;
import com.wayan.service.UserService;
import com.wayan.utils.JdbcUtils;

import java.sql.Connection;
import java.time.chrono.JapaneseDate;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        Connection conn = JdbcUtils.getConnection();
        int count = userDao.saveData(conn, user);
        JdbcUtils.closeConnection(conn);
        if(count == 0){
            System.out.println("注册失败！");
        }else{
            System.out.println("注册成功！");
        }
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryByUserAndPwd(username, password);
    }

    @Override
    public boolean existsName(String username) {
        return userDao.queryByUserName(username)!=null?true:false;
    }
}
