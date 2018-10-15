package com.task03.enums;

import java.util.*;

public abstract class CustomEnum<T extends CustomEnum<T>> implements Comparable<T> {

    private final String name;
    private final int ordinal;

    private static Set<CustomEnum> enums = new HashSet<>();
    private static int counter = 0;

    protected CustomEnum(String name) {
        this.name = name;
        this.ordinal = counter++;
        enums.add(this);
    }

    public final String name() {
        return name;
    }

    public final int ordinal() {
        return ordinal;
    }

    public static <T> T valueOf(String name) {
        T result = null;
        for (CustomEnum anEnum : enums) {
            if (anEnum.name.equals(name)) {
                result = (T) anEnum;
            }
        }
        return result;
    }

    public static <T> T[] values() {
        return (T[]) enums.toArray();
    }

    @Override
    public int compareTo(T o) {
        return this.ordinal - o.ordinal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomEnum<?> that = (CustomEnum<?>) o;

        if (ordinal != that.ordinal) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + ordinal;
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
