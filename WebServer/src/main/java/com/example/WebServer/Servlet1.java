package com.example.WebServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 请求转发
         */
        // 有没有带请求参数
        String username = request.getParameter("username");
        System.out.println("Servlet1的请求参数：" + username);

        // 给Servlet1加一个盖章
        request.setAttribute("key","Servlet1的章");

        // 获取转发的地址并转发
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Servlet2");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
