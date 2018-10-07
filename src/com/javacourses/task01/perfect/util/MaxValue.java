package com.javacourses.task01.perfect.util;

import java.util.Scanner;

public class MaxValue {

    public static int get() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a positive number: ");

            if (scan.hasNextInt()) {
                int i = scan.nextInt();
                if (i <= 0) continue;
                return i;
            }
            scan.next();
        }

    }
}
