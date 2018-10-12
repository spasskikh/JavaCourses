package com.javacourses.task02.figures.model.entity;

public class Rectangle extends Shape {

    private double a;
    private double b;
    private double area;

    public Rectangle() {
    }

    public Rectangle(String shapeColor, double a, double b) {
        super(shapeColor);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double calcArea() {
        return a * b;
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
