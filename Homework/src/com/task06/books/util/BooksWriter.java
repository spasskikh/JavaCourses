package com.task06.books.util;

import com.task06.books.model.entity.Book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BooksWriter {

    public static void write(Book[] books, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Book book : books) {
                String line = String.format("%s, %s, %s, %d, %d, %.2f\n",
                        book.getName(), book.getPublisher(), book.getAuthor(), book.getYear(), book.getPages(), book.getPrice());
                writer.write(line);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
