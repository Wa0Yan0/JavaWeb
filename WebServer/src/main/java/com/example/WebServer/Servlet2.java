package com.example.WebServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 有没有带请求参数
        String username = request.getParameter("username");
        System.out.println("Servlet2的请求参数：" + username);

        // 获取Servlet1的一个盖章
        Object key = request.getAttribute("key");
        System.out.println("Servlet1的盖章:" + key);

        System.out.println("Servlet2处理自己的业务");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
