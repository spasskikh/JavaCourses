package com.javacourses.task02.figures.model.data;

import com.javacourses.task02.figures.model.entity.Circle;
import com.javacourses.task02.figures.model.entity.Rectangle;
import com.javacourses.task02.figures.model.entity.Shape;
import com.javacourses.task02.figures.model.entity.Triangle;

public class DataSource {

    public static Shape[] get() {
        return new Shape[]{
                new Triangle("white", 10, 5),
                new Rectangle("green", 11, 6),
                new Rectangle("amber", 12, 7),
                new Triangle("red", 13, 8),
                new Circle("yellow", 1.5),
                new Rectangle("purple", 15, 9),
                new Circle("orange", 1.76),
                new Triangle("black", 17, 10),
                new Triangle("grey", 18, 10),
                new Circle("blue", 1.9),
        };
    }
}
