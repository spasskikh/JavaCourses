package com.task03.toys.controller;

import com.task02.figures.util.UserInput;
import com.task03.toys.model.GameRoom;
import com.task03.toys.model.data.DataSourcePlastic;
import com.task03.toys.model.enity.Toy;
import com.task03.toys.model.enity.ToyPlastic;
import com.task03.toys.view.View;

import java.util.Arrays;

public class ToysController {

    private GameRoom<ToyPlastic> room = new GameRoom<>();
    private View viewer = new View();
    private UserInput input = new UserInput();

    public void run() {
        room.setToys(DataSourcePlastic.get());

        viewer.printMenu();

        int switcher = input.getInt();
        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    viewer.printToys("ALL TOYS", room.getToys());
                    switcher = input.getInt();
                    break;
                case 2:
                    totalPrice();
                    switcher = input.getInt();
                    break;
                case 3:
                    sortByPrice();
                    switcher = input.getInt();
                    break;
                case 4:
                    getDefinedToys();
                    switcher = input.getInt();
                    break;
                default:
                    viewer.printMessage("Incorrect parameter.");
                    viewer.printMenu();
                    switcher = input.getInt();
                    break;
            }
        }
    }

    private void getDefinedToys() {
        Toy[] toys = room.getDefinedToys(100, "white");
        viewer.printToys("White toys cheaper than 100", toys);
    }

    private void sortByPrice() {
        Toy[] toys = room.getToys();
        Arrays.sort(toys, (t1, t2) -> t2.getPrice()-t1.getPrice());

        viewer.printToys("Sorted toys in descending order:", toys);
    }

    private void totalPrice() {
        viewer.printMessage("Total price for all toys in the room "+ room.getTotalPrice());
    }
}
