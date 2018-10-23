package com.task02.figures.util;

import com.task02.figures.model.entity.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {
        return (int)(s1.calcArea()-s2.calcArea());
    }
}
