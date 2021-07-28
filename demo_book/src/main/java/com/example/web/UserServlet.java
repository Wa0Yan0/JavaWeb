package com.example.web;

import com.example.pojo.User;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    /**
     * @function 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + "\n" + "password:" + password);
        User user = userService.login(username, password);
        if(user == null){
            System.out.println("登陆失败");
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登陆成功");
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * @function 注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 将请求参数赋值给对象
        User user = WebUtils.copyParamToBean(new User(), req.getParameterMap());
        System.out.println(user);

        req.setAttribute("email",email);
        req.setAttribute("username", username);

        // 检查验证码是否正确
        if(code.equals("1234")){
            System.out.println("验证码["+ code + "]正确");
            // 用户名是否可用
            if(userService.existsName(username)){
                System.out.println("用户名[" + username + "]已存在");
                req.setAttribute("msg", "用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                System.out.println("用户名[" + username + "]可用");
                // 保存数据到数据库
                userService.register(new User(username,password,email));
                // 跳转到成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            System.out.println("验证码["+ code + "]错误");
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}
