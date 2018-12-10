package com.task11.task11_02.service;

import com.task11.task11_02.dao.BookDAO;
import com.task11.task11_02.dao.BookDAOImp;
import com.task11.task11_02.dao.DBConnection;
import com.task11.task11_02.exception.UnExistItemMenu;
import com.task11.task11_02.model.entity.Book;
import com.task11.task11_02.util.ResourceManager;

import java.sql.Connection;
import java.util.*;

public class Service {

    private ResourceManager manager = ResourceManager.INSTANCE;
    private BookDAO dao;

    public Service() {
    }

    public String init() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return "Service is currently unavailable ";
        }
        dao = new BookDAOImp(conn);

        return null;
    }

    public String showAllBooks(String message) {
        return message + "\n" + convertBooksInString(dao.getAll());
    }

    private String convertBooksInString(Book[] books) {
        StringBuilder str = new StringBuilder();
        for (Book book : books) {
            str.append(String.format("%s\n", book));
        }
        return str.toString();
    }

    private String convertBooksInString(List<Book> books) {
        StringBuilder str = new StringBuilder();
        for (Book book : books) {
            str.append(String.format("%s\n", book));
        }
        return str.toString();
    }

    public String searchBooksByAuthor(String author) {
        List<Book> books = dao.find("author", author);
        if (books.size() == 0) {
            return manager.getMessage("NO_EMPLOYEES") + author;
        }
        return manager.getMessage("EMPS_DEP") + author + "\n" + convertBooksInString(books);
    }

    public String searchBooksByPublisher(String publisher) {
        List<Book> books = dao.find("publisher", publisher);
        if (books.size() == 0) {
            return manager.getMessage("NO_EMPLOYEES") + publisher;
        }
        return manager.getMessage("TASKS_EMP") + publisher + "\n" + convertBooksInString(books);
    }

    public String searchBooksAfterYear(int year) {
        List<Book> books = dao.find("year", Integer.toString(year));
        if (books.size() == 0) {
            return manager.getMessage("NO_TASKS") + year;
        }
        return manager.getMessage("BOOKS_AFTER_YEAR") + year + "\n" + convertBooksInString(books);
    }

    public String sortByPublisher(String message) {
        List<Book> books = dao.getAll();
        books.sort(Comparator.comparing(Book::getPublisher));
        return message + "\n" + convertBooksInString(books);
    }

    public void changeLanguage(int choice) throws UnExistItemMenu {
        manager.changeLocale(defineLocale(choice));
    }

    private Locale defineLocale(int number) throws UnExistItemMenu {
        Language[] languages = Language.values();
        if (number <= 0 || number > languages.length) {
            throw new UnExistItemMenu(manager.getMessage("WRONG_INPUT_DATA"));
        }
        return languages[number - 1].getLocale();
    }

    public void closeConnection() {
        DBConnection.closeConnection();
    }
}
