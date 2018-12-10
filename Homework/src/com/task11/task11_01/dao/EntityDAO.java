package com.task11.task11_01.dao;

import java.util.List;

public interface EntityDAO {

    List<String> getAll(String criteria);

    List<String> find(String criteria, String value);

    boolean create();
}
