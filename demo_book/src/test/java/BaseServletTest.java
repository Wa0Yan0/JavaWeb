import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServletTest {

    public void login(String username){
        System.out.println(username + "调用login方法");
    }
    public void register(String username){
        System.out.println(username + "调用register方法");
    }

    @Test
    public void main() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String username = "waYan";
        String methodName = "login";
        /**
         * @function 使用反射找到类的方法
         * @param methodName 方法名
         * @param string.class 方法的参数类型.class
         */
        Method method = this.getClass().getDeclaredMethod(methodName, String.class);
        /**
         * @function 调用方法
         * @param this 类对象
         * @param username 方法的参数
         */
        method.invoke(this, username);



    }
}
