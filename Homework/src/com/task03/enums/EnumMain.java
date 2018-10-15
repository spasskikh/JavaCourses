package com.task03.enums;

import java.util.Arrays;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println(TestEnum.ONE);
        System.out.println(TestEnum.TWO);
        System.out.println(TestEnum.THREE);
        System.out.println(TestEnum.FOUR);
        System.out.println(TestEnum.FIVE);
        System.out.println();

        System.out.println("ordinals for each enum:");
        System.out.println("" + TestEnum.ONE+ ": " + TestEnum.ONE.ordinal());
        System.out.println("" + TestEnum.TWO+ ": " + TestEnum.TWO.ordinal());
        System.out.println("" + TestEnum.THREE+ ": " + TestEnum.THREE.ordinal());
        System.out.println("" + TestEnum.FOUR+ ": " + TestEnum.FOUR.ordinal());
        System.out.println("" + TestEnum.FIVE+ ": " + TestEnum.FIVE.ordinal());
        System.out.println();

        System.out.println("Values:");
        System.out.println(Arrays.toString(TestEnum.values()));
        System.out.println();

        System.out.println("ValueOf one:");
        System.out.println(TestEnum.valueOf("one").toString());
    }
}

