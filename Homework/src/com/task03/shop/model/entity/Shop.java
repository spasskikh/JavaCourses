package com.task03.shop.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String name;

    private List<Department> deps;

    public Shop(String name) {
        this.name = name;
        this.deps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDeps() {
        return deps;
    }

    public void setDeps(List<Department> deps) {
        this.deps = deps;
    }

    public void addDep(String name, String typeOfGoods, String location) {
        deps.add(new Department(name, typeOfGoods, location));
    }

    public void killDep(String name) {
        int counter = 0;
        for (Department d : deps) {
            if (d.getName().equals(name)) {
                break;
            }
            counter++;
        }
        deps.remove(counter);
    }

    @Override
    public String toString() {
        return name + '\n' + deps;
    }

    public class Department {
        private String name;
        private String typeOfGoods;
        private String location;

        Department(String name, String typeOfGoods, String location) {
            this.name = name;
            this.typeOfGoods = typeOfGoods;
            this.location = location;
        }

        String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTypeOfGoods() {
            return typeOfGoods;
        }

        public void setTypeOfGoods(String typeOfGoods) {
            this.typeOfGoods = typeOfGoods;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Department " + name + " - " + typeOfGoods + " - " + location;
        }
    }
}
