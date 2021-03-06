package com.task06.books.util;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public int getInt() {

        while (true) {
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i < 0) continue;
                return i;
            }
            scanner.next();
        }
    }

    public String getLine() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
