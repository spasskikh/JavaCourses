package com.task02.figures.model;

import com.task02.figures.model.entity.Circle;
import com.task02.figures.model.entity.Shape;
import com.task02.figures.model.entity.Rectangle;
import com.task02.figures.model.entity.Triangle;

import java.util.Arrays;
import java.util.Comparator;

public class ShapesModel {

    private Shape[] shapes;

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double getTotalArea() {
        double res = 0;
        for (Shape s : shapes) {
            if (s instanceof Circle) {
                res += ((Circle) s).getArea();
            } else if (s instanceof Triangle) {
                res += ((Triangle) s).getArea();
            } else if (s instanceof Rectangle) {
                res += ((Rectangle) s).getArea();
            }
        }
        return res;
    }

    public double getFigureArea(String str) {
        double res = 0;
        for (Shape s : shapes) {
            if ("Circle".equals(str) && s instanceof Circle) {
                res += ((Circle) s).getArea();
            } else if ("Triangle".equals(str) && s instanceof Triangle) {
                res += ((Triangle) s).getArea();
            } else if ("Rectangle".equals(str) && s instanceof Rectangle) {
                res += ((Rectangle) s).getArea();
            }
        }
        return res;
    }


    public void sort(Comparator<Shape> comparator) {
        Arrays.sort(shapes, comparator);
    }
}
