package com.task03.shop.controller;

import com.task02.books.util.UserInput;
import com.task03.shop.model.ShopModel;
import com.task03.shop.model.data.DataSource;
import com.task03.shop.view.ShopViewer;

import java.util.Collections;

public class ShopController {

    private ShopModel model = new ShopModel();
    private ShopViewer viewer = new ShopViewer();
    private UserInput input = new UserInput();

    public void run() {
        model.setShop(DataSource.getShop());
        viewer.printMenu();

        int switcher = input.getInt();
        while (switcher != 0) {
            switch (switcher) {
                case 1:
                    viewer.printShop(model.getShop());
                    switcher = input.getInt();
                    break;
                case 2:
                    createDep();
                    switcher = input.getInt();
                    break;
                case 3:
                    deleteDep();
                    switcher = input.getInt();
                    break;
                case 4:
                    sortByTypes();
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

    private void sortByTypes() {
        Collections.sort(model.getShop().getDeps(), (d1, d2) -> d1.getTypeOfGoods().compareTo(d2.getTypeOfGoods()));
        viewer.printShop(model.getShop());
    }

    private void deleteDep() {
        viewer.printMessage("Please enter name:");
        model.killDep(input.getLine());
        viewer.printShop(model.getShop());
    }

    private void createDep() {
        viewer.printMessage("Please enter name:");
        String name = input.getLine();

        viewer.printMessage("Please enter type of goods:");
        String type = input.nextLine();

        viewer.printMessage("Please enter location:");
        String location = input.nextLine();

        model.addDeparment(name, type, location);

        viewer.printShop(model.getShop());
    }
}
