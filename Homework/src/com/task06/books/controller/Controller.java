package com.task06.books.controller;

import com.task06.books.model.BooksModel;
import com.task06.books.model.entity.Book;
import com.task06.books.util.BookComparator;
import com.task06.books.util.BooksReader;
import com.task06.books.util.UserInput;
import com.task06.books.view.BooksViewer;

public class Controller {

    private BooksModel model = new BooksModel();
    private BooksViewer viewer = new BooksViewer();
    private UserInput input = new UserInput();

    private String fileName = "/home/anton/Documents/java/IdeaProjects/JavaCourses/Homework/src/com/task06/books/model/data/data.txt";

    public void run() {
        model.setBooks(BooksReader.read(fileName));
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
                case 6:
                    createNewBook();
                    switcher = input.getInt();
                    break;
                default:
                    switcher = 0;
            }
        }

        model.saveChanges(fileName);
    }

    private void createNewBook() {
        Book newBook = new Book("BOOK", "PUBLISHER", "AUTHOR", 100, 100, 100.0);
        model.addNewBook(newBook);
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

        model.sort(new BookComparator());
        viewer.printBooks("Sorted by Publisher:", model.getBooks());
    }
}
