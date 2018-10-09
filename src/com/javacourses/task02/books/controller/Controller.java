package com.javacourses.task02.books.controller;

import com.javacourses.task02.books.model.BookComparator;
import com.javacourses.task02.books.model.Books;
import com.javacourses.task02.books.model.data.DataSource;
import com.javacourses.task02.books.model.entity.Book;
import com.javacourses.task02.books.util.UserInput;
import com.javacourses.task02.books.view.BooksViewer;

import java.util.Arrays;
import java.util.Scanner;

public class Controller {

    private Books model = new Books();
    private BooksViewer viewer = new BooksViewer();
    private Scanner scanner = new Scanner(System.in);
    private UserInput input = new UserInput();

    public void run() {
        model.setBooks(DataSource.getBooks());

        viewer.printMenu();

        viewer.printBooks("ALL BOOKS:",model.getBooks());

        findByAuthor("author");
        findByPublisher("publisher");
        findByYear(2005);
        sortByPublisher();


    }

    private void findByAuthor(String author) {

        Book[] byAuthor = model.getByAuthor(author);

        if (byAuthor.length==0) {
            viewer.printMessage("No books written by "+author);
        } else {
            viewer.printBooks("Found:",byAuthor);
        }
    }

    private void findByPublisher(String publisher) {

        Book[] byPublisher = model.getByPublisher(publisher);

        if (byPublisher.length==0) {
            viewer.printMessage("No books published by "+publisher);
        } else {
            viewer.printBooks("Found:",byPublisher);
        }
    }

    private void findByYear(int year) {

        Book[] byYear = model.getByYear(year);

        if (byYear.length==0) {
            viewer.printMessage("No books published after "+year);
        } else {
            viewer.printBooks("Found:",byYear);
        }
    }

    private void sortByPublisher() {

        Book[] books = model.getBooks();
        Arrays.sort(books, new BookComparator());
        viewer.printBooks("Sorted by Publisher:",books);
    }
}
