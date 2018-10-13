package com.task01.perfect.controller;

import com.task01.perfect.model.PerfectNumbers;
import com.task01.perfect.util.MaxValue;
import com.task01.perfect.view.Viewer;

public class PNsController {

    public static void find() {
        PerfectNumbers pn = new PerfectNumbers();
        pn.setMax(MaxValue.get());
        findPerfect(pn);
    }

    private static void findPerfect(PerfectNumbers pn) {
        int res = 0;

        for (int i = 1; i < pn.getMax(); i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    res += j;
                }
            }
            if (res == i) pn.getPns().add(i);
            res = 0;
        }
        Viewer.print(pn);
    }
}
