package com.task07.task07_03_04_05;

import java.util.*;
import java.util.function.Predicate;

public class Runner {

    public void run() {

        Integer[] intArray = createIntArray(10);
        System.out.println(Arrays.toString(intArray));

        Arrays.sort(intArray, (x, y) -> y.compareTo(x));
        Arrays.sort(intArray, Comparator.reverseOrder());
        System.out.println(Arrays.toString(intArray));

        List<String> stringList = createStringList();
        System.out.println(stringList);
        Collections.sort(stringList, Comparator.reverseOrder());
        System.out.println(stringList);

        int sum = sum(intArray, x -> x % 2 == 0);
        System.out.println(sum);
        System.out.println(sum(intArray, x -> x > 10 && x % 3 == 0));

        List<String> selectedStrings = selectStrings(stringList, x -> x.startsWith("a") || x.startsWith("c"));
        System.out.println(selectedStrings);

        toUpperCase(stringList, x -> x.toUpperCase());
        System.out.println(stringList);

        List<String> strings = Arrays.asList("", null, "  ", "  abc");
        toUpperCase(strings, String::toUpperCase);
//        ok when signatures in methods(functional interface and class) are the same
        System.out.println(strings);

    }

    private Integer[] createIntArray(int size) {
        Integer[] array = new Integer[size];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(20);
        }
        return array;
    }

    private List<String> createStringList() {
        List<String> list = new ArrayList<>();
        for (char c = 'a'; c <= 'k'; c++) {
            list.add("" + c + c);
        }

        Collections.shuffle(list);

        return list;
    }

    private int sum(Integer[] array, Predicate<Integer> filter) {
        int ss = 0;

        for (Integer value : array) {
            if (filter.test(value)) {
                ss += value;
            }
        }
        return ss;
    }

    private List<String> selectStrings(List<String> list, Predicate<String> filter) {

        List<String> newList = new ArrayList<>();
        for (String str : list) {
            if (filter.test(str)) {
                newList.add(str);
            }
        }
        return newList;
    }

    private void toUpperCase(List<String> list, ConvertString converter) {
        for (int i = 0; i < list.size(); i++) {
            if (converter.exists(list.get(i))) {
                list.set(i,converter.convert(list.get(i)));
            }
        }
    }
}
