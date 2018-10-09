package com.javacourses.task02.books.util;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public int get() {
        return scanner.nextInt();
    }
}
