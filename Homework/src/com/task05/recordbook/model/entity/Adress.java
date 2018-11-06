package com.task05.recordbook.model.entity;

public class Adress {

    private String city;
    private String street;
    private int house;
    private int apartment;

    public Adress() {
    }

    public Adress(String city, String street, int house, int apartments) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return String.format("%s, %s %d, app.%d", city, street, house, apartment);
    }
}
