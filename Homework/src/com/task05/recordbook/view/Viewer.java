package com.task05.recordbook.view;

import com.task05.recordbook.model.entity.Record;

import java.util.List;

public class Viewer {

    public void printMenu() {
        System.out.println(
                "Please choose an action:\n" +
                        "1 - Show current records;\n" +
                        "2 - Add new record;\n" +
                        "0 - Exit.");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void print(String message, List<Record> records) {
        System.out.println(message);
        for (Record r : records) {
            System.out.println(r);
        }
    }
}
