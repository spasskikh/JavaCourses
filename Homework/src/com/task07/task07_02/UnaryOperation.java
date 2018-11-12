package com.task07.task07_02;

public class UnaryOperation {

    private double value;

    public UnaryOperation() {
        this(100);
    }

    public UnaryOperation(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void unsigned() {
        value = -value;
    }

    @Override
    public String toString() {
        return "UnaryOperation{" +
                "value=" + value +
                '}';
    }
}
