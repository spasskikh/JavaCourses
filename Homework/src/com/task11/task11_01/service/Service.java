package com.task11.task11_01.service;

import com.task11.task11_01.dao.EntityDAO;
import com.task11.task11_01.dao.EntityDAOImp;
import com.task11.task11_01.dao.DBConnection;
import com.task11.task11_01.util.ResourceManager;

import java.sql.Connection;
import java.util.List;

public class Service {

    private ResourceManager manager = ResourceManager.INSTANCE;
    private EntityDAO dao;

    public Service() {
    }

    public String init() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return "Service is currently unavailable ";
        }
        dao = new EntityDAOImp(conn);

        return null;
    }

    public String showAll(String message, String criteria) {
        return message + "\n" + formatString(dao.getAll(criteria));
    }

    private String formatString(List<String> strings) {
        StringBuilder str = new StringBuilder();
        for (String string : strings) {
            str.append(String.format("%s\n", string));
        }
        return str.toString();
    }

    public String showEmpsByDep(int depId) {
        return null;
    }

    public String showTasksByEmp(int empId) {
        return null;
    }

    public String createNewTask(int empId) {
        return null;
    }

    public void closeConnection() {
        DBConnection.closeConnection();
    }
}
