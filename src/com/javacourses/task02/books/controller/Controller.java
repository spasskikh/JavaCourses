package com.javacourses.task02.books.controller;

import com.javacourses.task02.books.util.BookComparator;
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
    private UserInput input = new UserInput();

    public void run() {
        model.setBooks(DataSource.getBooks());
        viewer.printMenu();

        int switcher = input.getInt();
        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    viewer.printBooks("ALL BOOKS:", model.getBooks());
                    switcher = input.getInt();
                    break;
                case 2:
                    viewer.printMessage("Please enter an author: ");
                    findByAuthor(input.getLine());
                    switcher = input.getInt();
                    break;
                case 3:
                    viewer.printMessage("Please enter a publisher: ");
                    findByPublisher(input.getLine());
                    switcher = input.getInt();
                    break;
                case 4:
                    viewer.printMessage("Please enter a year: ");
                    findByYear(input.getInt());
                    switcher = input.getInt();
                    break;
                case 5:
                    sortByPublisher();
                    switcher = input.getInt();
                    break;
                case 0:
                    break;
                default:
                    switcher = 0;
            }
        }
    }

    private void findByAuthor(String author) {

        Book[] byAuthor = model.getByAuthor(author);

        if (byAuthor.length == 0) {
            viewer.printMessage("No books written by " + author);
        } else {
            viewer.printBooks("Found:", byAuthor);
        }
    }

    private void findByPublisher(String publisher) {

        Book[] byPublisher = model.getByPublisher(publisher);

        if (byPublisher.length == 0) {
            viewer.printMessage("No books published by " + publisher);
        } else {
            viewer.printBooks("Found:", byPublisher);
        }
    }

    private void findByYear(int year) {

        Book[] byYear = model.getByYear(year);

        if (byYear.length == 0) {
            viewer.printMessage("No books published after " + year);
        } else {
            viewer.printBooks("Found:", byYear);
        }
    }

    private void sortByPublisher() {

        Book[] books = model.getBooks();
        Arrays.sort(books, new BookComparator());
        viewer.printBooks("Sorted by Publisher:", books);
    }
}
