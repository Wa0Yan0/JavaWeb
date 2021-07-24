package com.example.WebServer;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet implements Servlet {

    /**
     * @fuction 初始化servlet
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 获取servlet-name的值
        System.out.println("servlet-name:" + servletConfig.getServletName());
        // 获取初始化参数username的值
        System.out.println("username:" + servletConfig.getInitParameter("username"));
        // 获取servletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}