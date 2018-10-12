package com.javacourses.task02.figures.model.entity;

public abstract class Shape implements Drawable {

    private String shapeColor;

    public abstract double calcArea();

    public Shape() {
    }

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (area: n/a) - " + " - " + shapeColor;
    }
}
