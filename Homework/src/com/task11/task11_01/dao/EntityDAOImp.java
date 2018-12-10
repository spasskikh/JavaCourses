package com.task11.task11_01.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntityDAOImp implements EntityDAO {

    static {
        Path path = Paths.get("/home/anton/Documents/java/IdeaProjects/JavaCourses/Homework/resources/task11_02/log4j2.xml");
        System.setProperty("log4j.configurationFile", path.toString());
    }

    private static final Logger logger = LogManager.getLogger(EntityDAOImp.class);

    private Connection conn;

    public EntityDAOImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<String> getAll(String criteria) {
        List<String> result = new ArrayList<>();
        try (Statement st = conn.createStatement()) {

            String query;
            if ("employees".equalsIgnoreCase(criteria)) {
                query = "SELECT * FROM EMPLOYEE";
            } else if ("tasks".equalsIgnoreCase(criteria)) {
                query = "SELECT * FROM TASK";
            } else {
                query = null;
            }

            result = convert(st.executeQuery(query));

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public List<String> find(String criteria, String value) {
        return null;
    }

    @Override
    public boolean create() {
        return false;
    }

    private List<String> convert(ResultSet resultSet) throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();

        StringBuilder headers = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            headers.append(String.format("%-20s",metaData.getColumnName(i)));
            headers.append(" | ");

        }
        list.add(headers.toString().trim());

        while (resultSet.next()) {
            StringBuilder row = new StringBuilder();
            for (int i = 1; i <= count; i++) {
                row.append(String.format("%-20s",resultSet.getString(i)));
                row.append(" | ");
            }
            list.add(row.toString().trim());
        }
        return list;
    }

}
