package com.task01.transform.controller;

public class Transformer {

    public static String binary(int i) {
        return "0b"+transform(i,2);
    }

    public static String octal(int i) {
        return "0" + transform(i,8);
    }

    public static String hexadecimal(int i) {
        return "0x" +transform(i,16);
    }

    private static String transform(int i, int base) {
        StringBuilder sb = new StringBuilder();

        while (i > (base - 1)) {
            sb.append(getChar(i % base));
            i = i / base;
        }
        sb.append(getChar(i % base));

        return sb.reverse().toString();
    }

    private static char getChar(int i) {

        char[] arr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        return arr[i];
    }

}
