package com.example.web;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    private BookServiceImpl bookService = new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.getInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.getInt(req.getParameter("pageSize"), 4);
        Page<Book> page = bookService.page(pageNo, pageSize, "client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
