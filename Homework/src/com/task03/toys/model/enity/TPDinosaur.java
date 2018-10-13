package com.task03.toys.model.enity;

public class TPDinosaur extends ToyPlastic {

    private Nutrition nutrition;

    public TPDinosaur(int price, String color, Nutrition nutrition) {
        super(price, color);
        this.nutrition = nutrition;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    @Override
    public String toString() {
        return super.toString() + "Dinosaur: " + nutrition;
    }
}
