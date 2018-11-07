package com.task06.books.util;

import com.task06.books.model.entity.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        if (b1.getPublisher().compareTo(b2.getPublisher()) != 0) {
            return b1.getPublisher().compareTo(b2.getPublisher());
        } else {
            return b1.getName().compareTo(b2.getName());
        }
    }
}
