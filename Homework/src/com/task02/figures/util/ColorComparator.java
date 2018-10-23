package com.task02.figures.util;

import com.task02.figures.model.entity.Shape;

import java.util.Comparator;

public class ColorComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return s1.getShapeColor().compareTo(s2.getShapeColor());
    }
}
