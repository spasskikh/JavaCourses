package com.task03.toys.model.enity;

public class TPSoldier extends ToyPlastic {

    private String arms;
    private String gender;

    public TPSoldier(int price, String color, String arms, String gender) {
        super(price, color);
        this.arms = arms;
        this.gender = gender;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return super.toString() + "Soldier: " +arms + ", "+gender;
    }
}
