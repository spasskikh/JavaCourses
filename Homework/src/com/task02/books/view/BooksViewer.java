package com.task02.books.view;

import com.task02.books.model.entity.Book;

public class BooksViewer {

    public void printBooks(String message, Book[] books) {
        System.out.println(message);
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        System.out.println(
                "Please choose an action:\n" +
                        "1 - Show all books;\n" +
                        "2 - Find all books written by Author;\n" +
                        "3 - Find all books published by Publisher;\n" +
                        "4 - Find all books published after the Date;\n" +
                        "5 - Sort books by Publisher;\n" +
                        "0 - Exit.");
    }

}
