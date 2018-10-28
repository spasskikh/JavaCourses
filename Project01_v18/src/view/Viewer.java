package view;

import java.util.List;

public class Viewer<T> {

    public void printLoans(String message, List<T> list) {
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
                        "1 - Show all information;\n" +
                        "2 - Show information about loans for chosen bank\n" +
                        "3 - Show information about chosen type of loan for all banks;\n" +
                        "4 - Modify the loan;\n" +
                        "0 - Exit.");
    }

}
