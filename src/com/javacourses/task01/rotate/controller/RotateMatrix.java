package com.javacourses.task01.rotate.controller;

import com.javacourses.task01.rotate.model.Matrix;
import com.javacourses.task01.rotate.util.MatrixSize;
import com.javacourses.task01.rotate.view.Viewer;

import java.util.concurrent.ThreadLocalRandom;

public class RotateMatrix {

    public static void go() {

        Matrix m = createMatrix();

        fillIn(m);
        Viewer.print(m);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        transpose(m);
        reverseColumns(m);
//        transposeExtra(m);
        Viewer.print(m);
    }

    private static Matrix createMatrix() {
        int size = MatrixSize.get();
        return new Matrix(size);
    }

    private static void fillIn(Matrix m) {
        int[][] arr = m.getArr();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
    }

    private static void transpose(Matrix m) {

        int[][] arr = m.getArr();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }

    private static void reverseColumns(Matrix m) {

        int[][] arr = m.getArr();

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
        }
    }

    private static void transposeExtra(Matrix m) {

        int[][] array = m.getArr();
        int size = array.length;
        int[][] newArray = new int[size][size];

        for (int i = 0; i < array.length; i++) {
            for (int j = size - 1, k = 0; j >= 0; j--, k++)
                newArray[k][i] = array[i][j];
        }
        m.setArr(newArray);
    }


}
