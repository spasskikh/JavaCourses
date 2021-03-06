package com.task03.toys.model.enity;

public abstract class ToySoft implements Toy {

    private static final String MATERIAL = "Wool";
    private int price;
    private String color;

    public ToySoft(int price, String color) {
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
}
