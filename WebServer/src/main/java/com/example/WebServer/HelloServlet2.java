package com.example.WebServer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloServlet2 extends HttpServlet {
    /**
     * @fuction 重写初始化方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        System.out.println("重写初始化方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法:");
        /**
         * 获取初始化参数
         */
        ServletConfig servletConfig = getServletConfig();
        System.out.println("username:" + servletConfig.getInitParameter("username"));
        System.out.println("---------------------------------------------------------------------------------");

        /**
         * 获取全局（上下文）参数
         */
        ServletContext servletContext = getServletContext();
        // 获取全局参数
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        // 获取工程路径
        String contextPath = servletContext.getContextPath();
        // 获取工程部署在服务器上的绝对路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("username:" + username + "\n" + "password:" + password);
        System.out.println("工程路径:" + contextPath +"\n" + "绝对路径:" + realPath);

        // 存取全局参数
        servletContext.setAttribute("key","value");
        // 获取全局参数
        String value = (String) servletContext.getAttribute("key");
        System.out.println("key:" + value);
        System.out.println("---------------------------------------------------------------------------------");

        /**
         * 获取请求参数
         */
        // 获取资源路径
        System.out.println("URI:" + req.getRequestURI());
        // 获取请求的URL
        System.out.println("URL:" + req.getRequestURL());
        // 获取客户端ip地址
        System.out.println("IP:" + req.getRemoteHost());
        // 获取请求头
        System.out.println("User-Agent:" + req.getHeader("User-Agent"));
        // 获取请求方式
        System.out.println("Method:" + req.getMethod());
        System.out.println("---------------------------------------------------------------------------------");

        /**
         * 往客户端回传字符串数据
         */
        // 修改服务器和浏览器的字符集，一定要在获取流对象之前使用
        resp.setContentType("text/html; charset=UTF-8");
        // 获取流对象
        PrintWriter writer = resp.getWriter();
        writer.write("王岩真帅");

        /**
         *  请求重定向
         */
        resp.sendRedirect("http://localhost:8080/WebServer");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法");

        /**
         * 获取客户端发来的参数
         */
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobbies));
        System.out.println("---------------------------------------------------------------------------------");
    }
}
