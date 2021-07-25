package com.wayan.dao.impl;

import com.wayan.dao.impl.BaseDao;
import com.wayan.utils.JdbcUtils;
import org.junit.Test;
import com.wayan.pojo.User;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class JdbcUtilsTest {
    @Test
    public void getConnectionTest() throws Exception {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        JdbcUtils.closeConnection(conn);
    }


}
