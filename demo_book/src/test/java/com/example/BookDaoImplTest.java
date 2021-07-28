package com.example;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "python爬虫","王岩",new BigDecimal(50), 100,10,null));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "python爬虫","王岩",new BigDecimal(55.5), 1000,9,null));
    }

    @Test
    public void deleteById() {
        bookDao.deleteById(21);
    }

    @Test
    public void queryById() {
        Book book = bookDao.queryById(20);
        System.out.println(book);
    }

    @Test
    public void queryAll() {
        List<Book> books = bookDao.queryAll();
        books.forEach(System.out::println);
    }
}