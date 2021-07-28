package com.example.service.impl;

import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
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
}
