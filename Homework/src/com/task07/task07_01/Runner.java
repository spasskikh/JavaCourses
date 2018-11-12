package com.task07.task07_01;

import javafx.scene.transform.Scale;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Runner {

    public void run() throws NoSuchFieldException, IllegalAccessException {
        String string = "Hello";

        System.out.println("Before modifying: " + string);

        Class<String> stringClass = String.class;

        Field value = stringClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(string, "new value".toCharArray());
//        value variable gets new link to the new char array, that's why doesn't matter bigger or smaller new value is.

        System.out.println("After modifying: " + string);
        System.out.print("Called by value \"Hello\": ");
        System.out.println("Hello");
    }

    public void runWithScanner() throws NoSuchFieldException, IllegalAccessException {
        String string = "Hello";
        System.out.println("Before modifying: " + string);

        Scanner scanner = new Scanner(System.in);
        Class<String> stringClass = String.class;

        Field value = stringClass.getDeclaredField("value");
        value.setAccessible(true);

        String newString = scanner.nextLine();
        value.set(string, newString.toCharArray());

        System.out.println("After modifying: " + string);

    }
}
