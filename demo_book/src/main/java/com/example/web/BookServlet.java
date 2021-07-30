package com.example.web;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookServiceImpl bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int count = WebUtils.getInt(req.getParameter("count"), 0);
        int pageNo = WebUtils.getInt(req.getParameter("pageNo"), 0);
        if(count == 4){
            pageNo += 1;
        }
        // 将参数赋值给对象
        Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
        System.out.println("class:" + book);
        // 写入数据库
        bookService.addBook(book);
        // 请求重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
        System.out.println(book);
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queryById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.getInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.getInt(req.getParameter("pageSize"), 4);
        Page<Book> page = bookService.page(pageNo, pageSize, "manager/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }


    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有数据到列表
        List<Book> books = bookService.queryAll();
        System.out.println("显示所有数据！！！");
        // 将数据列表存入域区域
        req.setAttribute("books", books);
        // 请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
