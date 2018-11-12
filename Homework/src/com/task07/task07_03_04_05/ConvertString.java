package com.task07.task07_03_04_05;

@FunctionalInterface
public interface ConvertString {

    String convert(String str);

    default boolean exists(String str) {
        return str != null && !"".equals(str.trim());
    }
}
