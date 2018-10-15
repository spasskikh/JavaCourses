package com.task03.shop.view;

import com.task03.shop.model.entity.Shop;

public class ShopViewer {

    public void printShop(Shop shop) {
        System.out.println(shop);
    }

    public void printMessage(String str) {
        System.out.println(str);
    }

    public void printMenu() {
        System.out.println(
                "Please choose an action:\n" +
                        "1 - Show all information about shop;\n" +
                        "2 - Create new department;\n" +
                        "3 - Delete department;\n" +
                        "4 - Sort departments by type of goods;\n" +
                        "0 - Exit.");
    }
}
