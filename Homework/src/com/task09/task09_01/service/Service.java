package com.task09.task09_01.service;

import com.task09.task09_01.model.Model;
import com.task09.task09_01.model.entity.Book;
import com.task09.task09_01.util.InputOutputFile;

import java.util.Arrays;
import java.util.Comparator;

public class Service {

    private Model model = new Model();

    public Service() {
        model.setBooks(InputOutputFile.load());
    }

    public String showAllBooks() {
        return convertBooksInString(model.getBooks());
    }

    private String convertBooksInString(Book[] books) {
        StringBuilder str = new StringBuilder();
        for (Book book : books) {
            str.append(String.format("%s\n", book));
        }
        return str.toString();
    }

    public String searchBooksByAuthor(String author) {
        Book[] books = model.getByAuthor(author);
        if (books.length == 0) {
            return "No books for : " + author;
        }
        return "Books with author: " + author + "\n" + convertBooksInString(books);
    }

    public String searchBooksByPublisher(String publisher) {
        Book[] books = model.getByPublisher(publisher);
        if (books.length == 0) {
            return "No books for : " + publisher;
        }
        return "Books with publisher:" + publisher + "\n" + convertBooksInString(books);
    }

    public String searchBooksAfterYear(int year) {
        Book[] books = model.getAfterYear(year);
        if (books.length == 0) {
            return "No books after : " + year + " year";
        }
        return "Books after " + year + " year:\n" + convertBooksInString(books);
    }

    public String sortByPublisher() {
        Book[] books = model.getBooks();
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublisher().compareTo(o2.getPublisher());
            }
        });
        return convertBooksInString(books);
    }

    public void saveBooks() {
        InputOutputFile.save(model.getBooks());
    }
}
