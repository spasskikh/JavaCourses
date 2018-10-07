package com.javacourses.task01.pyramid.util;

import java.util.Scanner;

public class PyramidHeight {

    public static int get() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a number from 1 to 9: ");

            if (scan.hasNextInt()) {
                int i = scan.nextInt();
                if (i < 1 || i > 9) continue;
                return i;
            }
            scan.next();
        }
    }
}
