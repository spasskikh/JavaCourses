package com.task03.enums;

public class TestEnum extends CustomEnum<TestEnum> {

    public static final TestEnum ONE = new TestEnum("one");
    public static final TestEnum TWO = new TestEnum("two");
    public static final TestEnum THREE = new TestEnum("three");
    public static final TestEnum FOUR = new TestEnum("four");
    public static final TestEnum FIVE = new TestEnum("five");

    public TestEnum(String name) {
        super(name);
    }

}

