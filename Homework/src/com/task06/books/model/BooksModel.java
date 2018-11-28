package com.task06.books.model;

import com.task06.books.model.entity.Book;
import com.task06.books.util.BooksWriter;

import java.util.Arrays;
import java.util.Comparator;

public class BooksModel {

    private Book[] books;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getByAuthor(String author) {
        Book[] temp = new Book[books.length];

        int counter = 0;

        for (int i = 0; i < temp.length; i++) {
            if (books[i].getAuthor().equals(author)) {
                temp[counter++] = books[i];
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public Book[] getByPublisher(String publisher) {
        Book[] temp = new Book[books.length];

        int counter = 0;

        for (int i = 0; i < temp.length; i++) {
            if (books[i].getPublisher().equals(publisher)) {
                temp[counter++] = books[i];
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public Book[] getByYear(int year) {
        Book[] temp = new Book[books.length];

        int counter = 0;

        for (int i = 0; i < temp.length; i++) {
            if (books[i].getYear() > year) {
                temp[counter++] = books[i];
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public void sort(Comparator<Book> comparator) {
        Arrays.sort(books, comparator);
    }

    public void saveChanges(String fileName) {
        BooksWriter.write(books, fileName);
    }

    public void addNewBook(Book newBook) {
        Book[] newBooks = new Book[books.length + 1];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        newBooks[newBooks.length - 1] = newBook;

        books = newBooks;
    }
}
