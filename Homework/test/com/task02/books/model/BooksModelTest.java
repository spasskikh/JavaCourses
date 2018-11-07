package com.task02.books.model;

import com.task02.books.model.entity.Book;
import com.task02.books.util.BookComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooksModelTest {

    private static Books model;
    private static Book b1;
    private static Book b2;
    private static Book b3;
    private static Book b4;
    private static Book b5;


    @BeforeAll
    public static void init() {
        model = new Books();

        b1 = new Book("Book5", "author3", "pub2", 2009, 200, 190.0);
        b2 = new Book("Book4", "author3", "pub3", 2006, 300, 160.0);
        b3 = new Book("Book3", "author1", "pub2", 2000, 400, 180.0);
        b4 = new Book("Book2", "author2", "pub1", 2000, 100, 170.0);
        b5 = new Book("Book1", "author2", "pub1", 2006, 300, 120.0);

        model.setBooks(new Book[]{b1, b2, b3, b4, b5});
        boolean flag = true;
        Book[] byPublisher = model.getByPublisher(b5.getPublisher());
        for (Book b : byPublisher) {
            if (!b.getPublisher().equals(b5.getPublisher())) {
                flag = false;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testGetByAuthor() {
        boolean flag = true;
        Book[] byAuthor = model.getByAuthor(b1.getAuthor());
        for (Book b : byAuthor) {
            if (!b.getAuthor().equals(b1.getAuthor())) {
                flag = false;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testGetByPublisher() {
        boolean flag = true;
        Book[] byPublisher = model.getByPublisher(b5.getPublisher());
        for (Book b : byPublisher) {
            if (!b.getPublisher().equals(b5.getPublisher())) {
                flag = false;
            }
        }
        assertTrue(flag);

    }

    @ParameterizedTest(name = "{index} => year={0}")
    @CsvSource({
            "2000",
            "2006"
    })
    public void testGetByYear(int year) {
        boolean flag = true;
        Book[] byYear = model.getByYear(year);
        for (Book b : byYear) {
            if (b.getYear() <= year) {
                System.out.println(b.getYear());
                flag = false;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testSort() {
        Book[] books = {b1, b2, b3, b4, b5};
        Arrays.sort(books, new BookComparator());

        model.sort(new BookComparator());

        assertArrayEquals(books, model.getBooks());
    }


}
