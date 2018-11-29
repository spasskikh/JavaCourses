package com.task09.task09_02.model;

import com.task09.task09_02.model.entity.Book;

import java.util.Arrays;

public class Model {

    private Book[] books;
    private int counter = 0;

    public Model() {
        books = new Book[10];
    }

    public Model(int size) {
        books = new Book[size];
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, counter);
    }

    public void setBooks(Book[] books) {
        if (this.books.length - counter < books.length) {
            this.books = Arrays.copyOf(this.books, this.books.length + books.length);
        }
        System.arraycopy(books, 0, this.books, counter, books.length);
        counter += books.length;
    }

    public void addBook(Book book) {
        if (counter == books.length) {
            books = Arrays.copyOf(books, books.length * 2);
        }
        books[counter++] = book;
    }

    public Book[] getByAuthor(String author) {
        Book[] temp = new Book[counter];
        int number = 0;
        for (int i = 0; i < this.counter; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                temp[number++] = books[i];
            }
        }
        return Arrays.copyOf(temp, number);
    }

    public Book[] getByPublisher(String publisher) {
        Book[] temp = new Book[books.length];
        int number = 0;
        for (int i = 0; i < this.counter; i++) {
            if (books[i].getPublisher().equals(publisher)) {
                temp[number++] = books[i];
            }
        }
        return Arrays.copyOf(temp, number);
    }

    public Book[] getAfterYear(int year) {
        Book[] temp = new Book[books.length];
        int number = 0;
        for (int i = 0; i < this.counter; i++) {
            if (books[i].getYear() >= year) {
                temp[number++] = books[i];
            }
        }
        return Arrays.copyOf(temp, number);
    }
}
