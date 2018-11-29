package com.task09.task09_01.view;

public class View {

    public static final String MAIN_MENU = " 1. Show all books" +
            "\n 2. Find by author" +
            "\n 3. Find by publisher" +
            "\n 4. Find books published after specified year" +
            "\n 5. Sort books by publisher " +
            "\n 0. Exit ";
    public static final String ALL_BOOKS = "All books :";
    public static final String INPUT_INT_DATA = "Choose operation: ";
    public static final String INPUT_STRING_DATA = "Enter string: ";
    public static final String WRONG_INPUT_DATA = "Incorrect input.";
    public static final String SORTED_BOOKS = "Sorted books by publisher: ";

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void printError(String str) {
        System.err.println(str);
    }

}
