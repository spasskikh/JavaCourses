package com.javacourses.task01.rotate.util;

import java.util.Scanner;

public class MatrixSize {

    public static int get() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a positive number: ");

            if (scan.hasNextInt()) {
                int i = scan.nextInt();
                if (i < 1) continue;
                return i;
            }
            scan.next();
        }
    }
}
