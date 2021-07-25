package com.wayan.dao.impl;

import com.wayan.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner runner = new QueryRunner();

    /**
     * @param sql
     * @param args
     * @return -1：跟新失败 updateCount:跟新行数
     * @function 实现增/删/改
     */
    public int update(Connection conn, String sql, Object... args) {
        try {
            return runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * @function 查询一条数据
     * @param tClass 任意类型的类
     * @param sql
     * @param args
     * @param <T> 任意类型
     * @return 类对象
     */
    public <T> T queryForOne(Class<T> tClass, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        T query = null;
        try {
            BeanHandler<T> handler = new BeanHandler<>(tClass);
            query = runner.query(conn, sql, handler, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return query;
    }

    /**
     * @function 查询多条数据
     * @param tClass
     * @param sql
     * @param args
     * @param <T>
     * @return 多个类对象的集合
     */
    public <T> List<T> queryForList(Class<T> tClass, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            BeanListHandler<T> handlers = new BeanListHandler<>(tClass);
            return runner.query(conn, sql, handlers, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    /**
     * @function 查询特殊数据
     * @param sql
     * @param args
     * @return 任意类型的数据
     */
    public Object queryForSingleValue(String sql, Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            ScalarHandler scalarHandler = new ScalarHandler();
            Object query = runner.query(conn, sql, scalarHandler, args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }


}
