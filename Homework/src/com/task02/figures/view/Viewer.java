package com.task02.figures.view;

import com.task02.figures.model.entity.Shape;

public class Viewer {

    public void printShapes(String message ,Shape[] shapes) {
        System.out.println(message);
        for (Shape s : shapes) {
            s.draw();
        }
    }

    public void printMessage(String str) {
        System.out.println(str);
    }

    public void printMenu() {
        System.out.println(
                "Please choose an action:\n" +
                        "1 - Show all figures;\n" +
                        "2 - Calculate total area of all figures;\n" +
                        "3 - Calculate total area of defined figures;\n" +
                        "4 - Sort figures by area;\n" +
                        "5 - Sort figures by color;\n" +
                        "0 - Exit.");
    }
}
