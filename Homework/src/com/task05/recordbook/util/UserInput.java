package com.task05.recordbook.util;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public int getInt(String str) {

        while (true) {
            System.out.print(str + " ");
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i < 0) continue;
                return i;
            }
            scanner.next();
        }
    }

    public String getLine(String str) {
        System.out.print(str + " ");
        return scanner.nextLine();
    }

    public void nextLine() {
        scanner.nextLine();
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }

}
