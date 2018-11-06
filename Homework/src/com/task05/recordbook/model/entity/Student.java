package com.task05.recordbook.model.entity;

import java.time.LocalDate;

public class Student {

    private String surname;
    private String name;
    private LocalDate datOfBirth;
    private String phonenumber;
    private Adress adress;

    public Student() {
    }

    public Student(String surname, String name, LocalDate datOfBirth, String phonenumber, Adress adress) {
        this.surname = surname;
        this.name = name;
        this.datOfBirth = datOfBirth;
        this.phonenumber = phonenumber;
        this.adress = adress;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDatOfBirth() {
        return datOfBirth;
    }

    public void setDatOfBirth(LocalDate datOfBirth) {
        this.datOfBirth = datOfBirth;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return String.format("%-18s %s\t%s\t%s", surname +" "+ name, datOfBirth, phonenumber, adress);
    }
}
