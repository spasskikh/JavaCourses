package com.task03.shop.model.data;

import com.task03.shop.model.entity.Shop;

public class DataSource {

    public static Shop getShop() {
        Shop shop = new Shop("DreamTown");

        shop.addDep("N01","food","North");
        shop.addDep("N02","books","West");
        shop.addDep("N03","clothes","East");
        shop.addDep("N04","shoes","South");
        shop.addDep("N05","jewelry","Southern-East");

        return shop;
    }
}
