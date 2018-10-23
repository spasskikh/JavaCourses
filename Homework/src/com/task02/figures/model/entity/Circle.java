package com.task02.figures.model.entity;

import java.util.Objects;

public class Circle extends Shape {

    private double r;
    private double area;

    public Circle(String shapeColor, double r) {
        super(shapeColor);
        this.r = r;
        area = calcArea();
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
    public String toString() {
        return super.toString() +" - area: "+ String.format("%.2f",area);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.r, r) == 0 &&
                Double.compare(circle.area, area) == 0;
    }

}
