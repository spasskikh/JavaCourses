package com.task01.rotate.model;

public class Matrix {

    private int sixe;

    private int[][] arr;

    public Matrix() {
    }

    public Matrix(int size) {
        arr = new int[size][size];
    }

    public int getSixe() {
        return sixe;
    }

    public void setSixe(int sixe) {
        this.sixe = sixe;
    }

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

}
