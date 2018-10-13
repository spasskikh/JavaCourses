package com.task02.figures.model.entity;

public abstract class Shape implements Drawable {

    private String shapeColor;

    Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public void draw() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - " + shapeColor;
    }
}
