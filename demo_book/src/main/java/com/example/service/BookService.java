package com.example.service;

import com.example.pojo.Book;
import com.example.pojo.Page;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void updateBook(Book book);

    void deleteById(int id);

    Book queryById(int id);

    List<Book> queryAll();

    Page<Book> page(Integer pageNo, Integer pageSize, String url);

}
