package com.task05.recordbook.model.entity;

public class Record {

    private static int count;
    private int number;
    private Student student;

    public Record(Student student) {
        this.student = student;
        this.number = ++count;
    }

    public static int getCount() {
        return count;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", number, student);
    }
}
