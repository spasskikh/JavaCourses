package com.task06.books.util;

import com.task06.books.model.entity.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BooksReader {

    public static Book[] read(String fileName) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(createBook(line));
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        return books.toArray(new Book[0]);
    }

    private static Book createBook(String line) {
        String[] fields = line.split(",");
        return new Book(fields[0],
                fields[1].trim(),
                fields[2].trim(),
                Integer.parseInt(fields[3].trim()),
                Integer.parseInt(fields[4].trim()),
                Double.parseDouble(fields[5].trim()));
    }
}
