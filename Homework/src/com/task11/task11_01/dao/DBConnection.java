package com.task11.task11_01.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

    static {
        Path path = Paths.get("/home/anton/Documents/java/IdeaProjects/JavaCourses/Homework/resources/task11_01/log4j2.xml");
        System.setProperty("log4j.configurationFile", path.toString());
    }


    private static Connection conn;
    private static Logger logger =  LogManager.getLogger(DBConnection.class);

    private DBConnection() {
    }

    public static Connection getConnection() {
        if (conn == null) {
            conn = createConnection();
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
               logger.error(e.getMessage());
            }
        }
    }

    private static Connection createConnection(){

        ResourceBundle resource = ResourceBundle.getBundle("task11_01/db");

        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("pass");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
}

