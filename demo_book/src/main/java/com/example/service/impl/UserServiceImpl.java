package com.example.service.impl;



import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.JdbcUtils;

import java.sql.Connection;

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
