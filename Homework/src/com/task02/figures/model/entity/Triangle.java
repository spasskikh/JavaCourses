package com.task02.figures.model.entity;

public class Triangle extends Shape {

    private double a;
    private double h;
    private double area;

    public Triangle(String shapeColor, double a, double h) {
        super(shapeColor);
        this.a = a;
        this.h = h;
        area = calcArea();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double calcArea() {
        return a / 2 * h;
    }

    @Override
    public String toString() {
        return super.toString() +" - area: "+ String.format("%.2f",area);
    }
}
