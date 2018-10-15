package com.task03.shop.model;

import com.task03.shop.model.entity.Shop;

public class ShopModel {

    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addDeparment(String name, String typeOfGoods, String location) {
        shop.addDep(name, typeOfGoods, location);
    }

    public void killDep(String name) {
        shop.killDep(name);
    }


}
