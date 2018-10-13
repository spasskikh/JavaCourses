package com.task03.toys.model;

import com.task03.toys.model.enity.Toy;
import java.util.Arrays;

public class GameRoom<T extends Toy> {

    private T[] toys;

    public T[] getToys() {
        return toys;
    }

    public void setToys(T[] toys) {
        this.toys = toys;
    }

    public int getTotalPrice() {
        int res = 0;

        for (T t : toys) {
            res += t.getPrice();
        }

        return res;
    }

    public T[] getDefinedToys(int price, String color) {

        T[] temp = (T[]) new Toy[toys.length];
        int counter = 0;

        for (int i = 0; i < temp.length; i++) {
            if (toys[i].getPrice()<=price && toys[i].getColor().equals(color)) {
                temp[counter++] = toys[i];
            }
        }
        return Arrays.copyOf(temp, counter);
    }
}
