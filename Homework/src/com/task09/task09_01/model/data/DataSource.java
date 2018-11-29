package com.task09.task09_01.model.data;

import com.task09.task09_01.model.entity.Book;

public class DataSource {

    public static Book[] getBooks() {
        return new Book[]{
                new Book("Book1", "author1", "pub1", 2000, 100, 100.0),
                new Book("Book5", "author5", "pub5", 2004, 500, 140.0),
                new Book("Book4", "author4", "pub1", 2000, 400, 130.0),
                new Book("Book2", "author2", "pub2", 2001, 200, 110.0),
                new Book("Book9", "author6", "pub4", 2009, 200, 190.0),
                new Book("Book6", "author5", "pub2", 2006, 300, 160.0),
                new Book("Book8", "author3", "pub3", 2000, 400, 180.0),
                new Book("Book7", "author5", "pub3", 2007, 100, 170.0),
                new Book("Book3", "author5", "pub3", 2002, 300, 120.0)
        };
    }
}
