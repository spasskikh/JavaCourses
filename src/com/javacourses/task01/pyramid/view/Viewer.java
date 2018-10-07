package com.javacourses.task01.pyramid.view;

import com.javacourses.task01.pyramid.model.Pyramid;

public class Viewer {

    public static void print(Pyramid p) {

        for (char[] line : p.getBody()) {
            System.out.println(line);
        }
    }
}
