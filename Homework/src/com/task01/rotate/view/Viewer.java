package com.task01.rotate.view;

import com.task01.rotate.model.Matrix;

public class Viewer {

    public static void print(Matrix matrix) {
        for (int[] line : matrix.getArr()) {
            for (int i : line) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
        System.out.println();

    }
}
