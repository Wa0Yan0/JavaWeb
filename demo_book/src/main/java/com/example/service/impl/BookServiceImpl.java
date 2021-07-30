package com.example.service.impl;

import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDaoImpl bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book queryById(int id) {
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryAll() {
        return bookDao.queryAll();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize, String url) {
        Page<Book> page = new Page<>();
        // 设置显示个数
        page.setPageSize(pageSize);
        // 设置总记录
        int pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        // 设置总页数
        int pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize != 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 设置当前页
        page.setPageNo(pageNo);
        // 设置显示数据
        page.setItems(bookDao.queryForItems((page.getPageNo()-1)*pageSize, pageSize));
        // 设置请求路径
        page.setUrl(url);
        return page;
    }


}
