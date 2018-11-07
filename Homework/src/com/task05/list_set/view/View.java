package com.task05.list_set.view;

import java.util.List;
import java.util.Set;

public class View {

    public void printMessage(String str) {
        System.out.println(str);
    }

    public void printCollections(Set<Integer> set, List<Integer> list) {
        System.out.println("Set:\n"+set);
        System.out.println("List:\n"+list);
    }
}
