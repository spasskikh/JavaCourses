package com.task09.task09_01.util;


import com.task09.task09_01.view.View;

import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(View view) {
        view.printMessage(View.INPUT_INT_DATA);
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    public static String inputString(View view) {
        while (true) {
            view.printMessage(View.INPUT_STRING_DATA);
            String text = sc.next();
            if (Validator.isCorrectString(text)) {
                return text;
            }
            view.printError(View.WRONG_INPUT_DATA);
        }
    }
}
