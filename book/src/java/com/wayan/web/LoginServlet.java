package com.wayan.web;

import com.wayan.pojo.User;
import com.wayan.service.UserService;
import com.wayan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + "\n" + "password:" + password);
        User user = userService.login(username, password);
        if(user == null){
            System.out.println("登陆失败");
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登陆成功");
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
