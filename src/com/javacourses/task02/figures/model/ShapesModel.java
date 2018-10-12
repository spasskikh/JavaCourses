package com.javacourses.task02.figures.model;

import com.javacourses.task02.figures.model.entity.Circle;
import com.javacourses.task02.figures.model.entity.Shape;
import com.javacourses.task02.figures.model.entity.Rectangle;
import com.javacourses.task02.figures.model.entity.Triangle;

public class ShapesModel {

    private Shape[] shapes;

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    public void drawFigure() {
        for (Shape s : shapes) {
            s.draw();
        }
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

    public double getFigureArea(Object o) {
        double res = 0;
        for (Shape s : shapes) {
            if (o instanceof Circle && s instanceof Circle) {
                res += ((Circle) s).getArea();
            } else if (o instanceof Triangle && s instanceof Triangle) {
                res += ((Triangle) s).getArea();
            } else if (o instanceof Rectangle && s instanceof Rectangle) {
                res += ((Rectangle) s).getArea();
            }
        }
        return res;
    }


}
