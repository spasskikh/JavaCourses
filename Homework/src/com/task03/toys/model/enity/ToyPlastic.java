package com.task03.toys.model.enity;

public abstract class ToyPlastic implements Toy {

    private static final String MATERIAL = "Plastic";
    private int price;
    private String color;

    public ToyPlastic(int price, String color) {
        this.price = price;
        this.color = color;
    }

    public static String getMATERIAL() {
        return MATERIAL;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Plastic toy: price = " + price +", color = " + color+ "; ";
    }
}
