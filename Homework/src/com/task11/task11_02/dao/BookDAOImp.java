package com.task11.task11_02.dao;

import com.task11.task11_02.model.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImp implements BookDAO {

    static {
        Path path = Paths.get("/home/anton/Documents/java/IdeaProjects/JavaCourses/Homework/resources/task11_02/log4j2.xml");
        System.setProperty("log4j.configurationFile", path.toString());
    }
    private static final Logger logger = LogManager.getLogger(BookDAOImp.class);

    private Connection conn;

    public BookDAOImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM BOOKS");

            while (resultSet.next()) {
                books.add(createBook(resultSet));
            }
            logger.info("Information successfully queried.");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return books;
    }

    @Override
    public List<Book> find(String criteria, String value) {
        List<Book> books = new ArrayList<>();

        String query = defineQuery(criteria, value);

        try (Statement st = conn.createStatement()) {
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                books.add(createBook(resultSet));
            }
            logger.info("Information successfully queried.");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return books;
    }

    private String defineQuery(String criteria, String value) {
        String query;
        if ("year".equalsIgnoreCase(criteria)) {
            query = String.format(
                    "SELECT * FROM BOOKS WHERE %s > %s", criteria.toUpperCase(), value);
        } else {
            query = String.format(
                    "SELECT * FROM BOOKS WHERE %s LIKE '%s'", criteria.toUpperCase(), value);
        }
        return query;
    }

    private Book createBook(ResultSet resultSet) throws SQLException {
        return new Book(
                resultSet.getString("NAME"),
                resultSet.getString("AUTHOR"),
                resultSet.getString("PUBLISHER"),
                resultSet.getInt("YEAR"),
                resultSet.getInt("PAGES"),
                resultSet.getDouble("PRICE")
        );
    }

}
