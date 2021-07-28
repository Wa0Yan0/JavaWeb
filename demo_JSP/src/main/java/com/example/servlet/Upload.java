package com.example.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断上传的数据是否为多断数据(true,文件上传）
        if(ServletFileUpload.isMultipartContent(req)){
            // 创建工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 从工厂类中，解析用于上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 解析上传的数据，得到每一个表单项
                List<FileItem> fileItems = servletFileUpload.parseRequest(req);
                // 循环判断，每一个表单项是，普通的数据，还是上传的文件
                for (FileItem fileItem : fileItems) {
                    if(fileItem.isFormField()){
                        // true,普通的表单项
                        System.out.println("表单项name的值：" + fileItem.getFieldName());
                        System.out.println("表单项value的值：" + fileItem.getString("UTF-8"));
                    }else{
                        // false,上传的文件
                        System.out.println("表单项name的值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        // 指定存储的路径
                        fileItem.write(new File("/Users/wayan/Documents/Java/JavaWeb/demo_JSP/src/main/webapp/static/imgs/" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
