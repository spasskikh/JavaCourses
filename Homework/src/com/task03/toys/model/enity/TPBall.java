package com.task03.toys.model.enity;

public class TPBall extends ToyPlastic{

    public TPBall(int price, String color) {
        super(price, color);
    }

    @Override
    public String toString() {
        return super.toString() + "Ball";
    }
}
