package com.task05.list_set.controller;

import com.task05.list_set.model.ListSetModel;
import com.task05.list_set.view.View;
import com.task05.recordbook.util.UserInput;

public class ListSetController {

    private ListSetModel model;
    private UserInput input;
    private View viewer;

    public ListSetController() {
        model = new ListSetModel();
        input = new UserInput();
        viewer = new View();
    }

    public void run() {
        int qty = input.getInt("Please enter quantity: ");

        viewer.printMessage("Please specify range.");
        int min = input.getInt("Min: ");
        int max = input.getInt("Max: ");

        while (max <= min) {
            viewer.printMessage("Incorrect input. Max should be greater than min.");
            min = input.getInt("Min: ");
            max = input.getInt("Max: ");
        }

        model.init(qty, min, max);

        viewer.printCollections(model.getSet(), model.getList());
    }
}
