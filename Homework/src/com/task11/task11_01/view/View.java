package com.task11.task11_01.view;

public class View {

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void printError(String str) {
        System.out.println("\u001B[31m" + str + "\u001B[0m");
    }

}
