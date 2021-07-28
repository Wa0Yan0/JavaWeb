package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;

import java.sql.Connection;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryByUserName(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        User user = queryForOne(User.class, sql, username);
        return user;
    }

    @Override
    public User queryByUserAndPwd(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password= ?";
        User user = queryForOne(User.class, sql, username, password);
        return user;
    }

    @Override
    public int saveData(Connection conn, User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        int count = update(conn, sql, user.getUsername(), user.getPassword(), user.getEmail());
        return count;
    }
}
