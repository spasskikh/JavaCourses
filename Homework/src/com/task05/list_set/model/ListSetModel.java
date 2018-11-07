package com.task05.list_set.model;

import java.util.*;

public class ListSetModel {

    private Set<Integer> set;
    private List<Integer> list;

    public ListSetModel() {
        set = new LinkedHashSet<>();
        list = new LinkedList<>();
    }

    public Set<Integer> getSet() {
        return set;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void init(int qty, int min, int max) {
        for (int i = 0; i < qty; i++) {
            int r = new Random().nextInt((max - min) + 1) + min;
            set.add(r);
            list.add(r);
        }
    }
}
