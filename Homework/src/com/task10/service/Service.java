package com.task10.service;

import com.task10.exception.UnExistItemMenu;
import com.task10.model.Model;
import com.task10.model.entity.Book;
import com.task10.util.InputOutputFile;
import com.task10.util.ResourceManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Service {

    private Model model = new Model();
    private ResourceManager manager = ResourceManager.INSTANCE;

    public Service() {
        model.setBooks(InputOutputFile.load());
    }

    public String showAllBooks(String message) {
        return message + "\n" + convertBooksInString(model.getBooks());
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
            return manager.getMessage("NO_BOOKS") + author;
        }
        return manager.getMessage("BOOKS_AUTHOR") + author + "\n" + convertBooksInString(books);
    }

    public String searchBooksByPublisher(String publisher) {
        Book[] books = model.getByPublisher(publisher);
        if (books.length == 0) {
            return manager.getMessage("NO_BOOKS") + publisher;
        }
        return manager.getMessage("BOOKS_PUBLISH") + publisher + "\n" + convertBooksInString(books);
    }

    public String searchBooksAfterYear(int year) {
        Book[] books = model.getAfterYear(year);
        if (books.length == 0) {
            return manager.getMessage("NO_BOOKS_YEAR") + year;
        }
        return manager.getMessage("BOOKS_AFTER_YEAR") + year + "\n" + convertBooksInString(books);
    }

    public String sortByPublisher(String message) {
        Book[] books = model.getBooks();
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublisher().compareTo(o2.getPublisher());
            }
        });
        return message + "\n" + convertBooksInString(books);
    }

    public void saveBooks() {
        InputOutputFile.save(model.getBooks());
    }

    public void changeLanguage(int choice) throws UnExistItemMenu {
        manager.changeLocale(defineLocale(choice));
    }

    private Locale defineLocale(int number) throws UnExistItemMenu {
        Language[] languares = Language.values();
        if (number <= 0 || number > languares.length) {
            throw new UnExistItemMenu(manager.getMessage("WRONG_INPUT_DATA"));
        }
        return languares[number - 1].getLocale();
    }
}
