package com.example.dao;

import com.example.pojo.Book;

import java.util.List;

public interface BookDao {

    public abstract void addBook(Book book);

    public abstract void updateBook(Book book);

    public abstract void deleteById(int id);

    public abstract Book queryById(int id);

    public abstract List<Book> queryAll();

}
