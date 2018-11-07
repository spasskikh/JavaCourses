package com.task05.translator.view;

import java.util.Map;
//fixing
public class View {

    public void printMessage(String str) {
        System.out.println(str);
    }

    public void printDictionary(Map<String, String> dictionary) {
        for (String key : dictionary.keySet()) {
            System.out.printf("%-6s - %s\n", key, dictionary.get(key));
        }

    }

    public void printMenu() {
        System.out.println(
                "Please choose an action:\n" +
                        "1 - Print dictionary;\n" +
                        "2 - Add new word to the dictionary;\n" +
                        "3 - Translate \"This is red table\";\n" +
                        "4 - Translate \"This is black table\";\n" +
                        "0 - Exit.");
    }
}
