package com.example.dao.impl;

import com.example.dao.BookDao;
import com.example.pojo.Book;
import com.example.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.JDBCType;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BookDaoImpl extends BaseDao implements BookDao {

    private Connection conn = JdbcUtils.getConnection();

    @Override
    public void addBook(Book book) {
        String sql = "insert into t_book(name,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        int count = update(conn, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
        JdbcUtils.closeConnection(conn);
        System.out.println(count + "行，受影响！！！");
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id =?";
        int count = update(conn, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
        JdbcUtils.closeConnection(conn);
        System.out.println(count + "行，受影响！！！");
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from t_book where id = ?";
        int count = update(conn, sql, id);
        JdbcUtils.closeConnection(conn);
        System.out.println(count + "行，受影响！！！");
    }

    @Override
    public Book queryById(int id) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryAll() {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book";
        List<Book> books = queryForList(Book.class, sql);
        return books;
    }
}
