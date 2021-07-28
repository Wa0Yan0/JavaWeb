import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import com.example.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryByUser() {
        User waYan = userDao.queryByUserName("wayan");
        if(waYan != null){
            System.out.println("用户名已存在！！！");
        }else{
            System.out.println("用户名可用！！！");
        }
    }

    @Test
    public void queryByUsrAndPwd() {
        User user = userDao.queryByUserAndPwd("wayan", "123");
        if(user!=null){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
    }

    @Test
    public void saveData() {
        Connection conn = JdbcUtils.getConnection();
        int count = userDao.saveData(conn, new User("gaoXun", "123", "gaoXun@gmail.com"));
        JdbcUtils.closeConnection(conn);
        System.out.println("OK！，" + count + "行受影响");
    }
}