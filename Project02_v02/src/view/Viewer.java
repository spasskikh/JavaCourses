package view;

import java.util.List;

public class Viewer<T> {

    public void printText(String message, List<T> list) {
        System.out.println(message);
        for (T t : list) {
            System.out.println(t);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        System.out.println(
                "Please choose an action:\n" +
                        "1 - Analyze text and display 10 smallest sentences;\n" +
                        "0 - Exit.");
    }

}
