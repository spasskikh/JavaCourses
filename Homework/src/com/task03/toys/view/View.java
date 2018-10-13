package com.task03.toys.view;

import com.task03.toys.model.enity.Toy;

public class View {

    public void printMessage(String str) {
        System.out.println(str);
    }

    public void printToys(String str, Toy[] toys) {
        System.out.println(str);
        for (Toy t : toys) {
            System.out.println(t);
        }

    }

    public void printMenu() {
        System.out.println(
                "Please choose an action:\n" +
                        "1 - Show all toys in the room;\n" +
                        "2 - Calculate total price of all toys;\n" +
                        "3 - Sort toys by price in descending order;\n" +
                        "4 - Get white toys cheaper than 100;\n" +
                        "0 - Exit.");
    }
}
