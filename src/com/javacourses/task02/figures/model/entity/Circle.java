package com.javacourses.task02.figures.model.entity;

public class Circle extends Shape {

    private double r;
    private double area;

    public Circle() {
    }

    public Circle(String shapeColor, double r) {
        super(shapeColor);
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public void draw() {
        area = calcArea();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (area: " + String.format("%.2f", area) + ") - " + getShapeColor();
    }
}
