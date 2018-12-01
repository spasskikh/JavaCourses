package com.task11.task11_02.dao;

import com.task11.task11_02.model.entity.Book;

import java.util.List;

public interface BookDAO {

//    void create(Book book);

//    boolean delete(Book book);

    List<Book> getAll();

    List<Book> find(String criteria, String value);
}
