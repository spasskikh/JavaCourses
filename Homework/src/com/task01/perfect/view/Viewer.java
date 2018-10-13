package com.task01.perfect.view;

import com.task01.perfect.model.PerfectNumbers;

public class Viewer {

    public static void print(PerfectNumbers pn) {
        System.out.println("Perfect numbers in the range from 0 to " + pn.getMax() + ":\n" + pn.getPns());
    }
}
