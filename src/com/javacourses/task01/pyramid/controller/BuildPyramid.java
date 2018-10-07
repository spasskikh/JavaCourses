package com.javacourses.task01.pyramid.controller;

import com.javacourses.task01.pyramid.model.Pyramid;
import com.javacourses.task01.pyramid.util.PyramidHeight;
import com.javacourses.task01.pyramid.view.Viewer;

import java.util.Arrays;

public class BuildPyramid {

    public static void go() {

        build();

    }

    private static void build() {
        Pyramid p = new Pyramid();

        int hight = PyramidHeight.get();
        p.setHight(hight);

        char[][] body = new char[hight][hight * 2 - 1];
        for (char[] line : body) {
            Arrays.fill(line, ' ');
        }
        p.setBody(body);

        fillIn(p);

        Viewer.print(p);
    }

    private static void fillIn(Pyramid p) {

        char[][] body = p.getBody();

        int max = p.getHight();
        int index = 0;
        int elem = 0;

        for (int i = body.length - 1; i >= 0; i--) {
            for (int j = index; j < max; j++) {
                body[i][j] = getElem(++elem);
            }
            for (int j = max; j < body[i].length - index; j++) {
                body[i][j] = getElem(--elem);
            }
            index++;
            elem = 0;
        }
    }

    private static char getElem(int i) {
        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        return arr[i];
    }
}
