package com.example.dao;

import com.example.pojo.User;

import java.sql.Connection;

public interface UserDao {

    /**
     * @function 根据用户名查询数据
     * @param username
     * @return User对象 如果是null，则查询失败
     */
    public abstract User queryByUserName(String username);


    /**
     * @function 根据用户名和密码查询数据
     * @param username
     * @param password
     * @return User对象 如果是null，则查询失败
     */
    public abstract User queryByUserAndPwd(String username, String password);

    /**
     * @function 将数据跟新到数据库
     * @param conn
     * @return 跟新行数，跟新失败为-1
     */
    public abstract int saveData(Connection conn, User user);
}
