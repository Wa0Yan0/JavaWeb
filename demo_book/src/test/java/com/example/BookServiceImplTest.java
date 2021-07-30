package com.example;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private BookServiceImpl bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.updateBook(new Book(22, "python爬虫","王岩",new BigDecimal(55.5), 1000,9,null));
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void deleteById() {
        bookService.deleteById(22);
    }

    @Test
    public void queryById() {
        Book book = bookService.queryById(20);
        System.out.println(book);
    }

    @Test
    public void queryAll() {
        List<Book> books = bookService.queryAll();
        books.forEach(System.out::println);

    }

    @Test
    public void page(){
        Page<Book> page = bookService.page(0, 4, "manager/bookServlet?action=page");
        System.out.println(page);
    }
}