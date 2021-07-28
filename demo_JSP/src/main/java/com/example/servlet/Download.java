package com.example.servlet;

import org.apache.commons.io.IOUtils;
import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要下载的文件名
        String downFileName = "证件照.jpeg";
        // 下载文件路径
        String filePath = "/static/imgs/" + downFileName;
        // 创建ServletContext对象
        ServletContext servletContext = getServletContext();
        // 获取下载文件的类型
        String mimeType = servletContext.getMimeType(filePath);
        // 告诉客户端回传的数据类型
        resp.setContentType(mimeType);
        // 设置响应头，告诉客户端数据用于下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downFileName,"UTF-8"));
        // 读取下载文件，变成流对象
        InputStream resourceAsStream = servletContext.getResourceAsStream(filePath);
        // 获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        // 将输入流中的数据，复制给输出流，发送给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
