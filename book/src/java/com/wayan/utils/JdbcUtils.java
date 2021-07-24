package com.wayan.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;

    static {
        try {
            // 读配置文件
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemResourceAsStream("JDBC.properties");
            pro.load(is);
            // 创建连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @function 获取数据库连接池中的连接
     * @return conn -连接成功 null -连接失败
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 获取连接
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * @function 关闭连接，放回数据库连接池
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
