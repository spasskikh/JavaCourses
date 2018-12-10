package com.task11.task11_01.util;


import com.task11.task11_01.view.View;

import java.util.Scanner;

public class InputUtility {

    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(View view, ResourceManager manager) {
        view.printMessage(manager.getMessage("INPUT_COMMAND"));
        while (!sc.hasNextInt()) {
            view.printMessage(manager.getMessage("WRONG_INPUT_DATA") + manager.getMessage("INPUT_COMMAND"));
            sc.next();
        }
        return sc.nextInt();
    }

    public static String inputString(View view, ResourceManager manager) {
        while (true) {
            view.printMessage(manager.getMessage("INPUT_STRING_DATA"));
            String text = sc.next();
            if (Validator.isCorrectString(text)) {
                return text;
            }
            view.printError(manager.getMessage("WRONG_INPUT_DATA"));
        }
    }
}
