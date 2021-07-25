package com.wayan.web;


import com.wayan.pojo.User;
import com.wayan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        System.out.println("username:" + username + "\n" + "password:" + password);
        System.out.println("email:" + email + "\n" + "code:" + code);


        // 检查验证码是否正确
        if(code.equals("1234")){
            System.out.println("验证码["+ code + "]正确");
            // 用户名是否可用
            if(userService.existsName(username)){
                System.out.println("用户名[" + username + "]已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }else{
                System.out.println("用户名[" + username + "]可用");
                // 保存数据到数据库
                userService.register(new User(username,password,email));
                // 跳转到成功页面
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        }else{
            System.out.println("验证码["+ code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
