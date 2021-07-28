import com.example.utils.JdbcUtils;
import org.junit.Test;
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
