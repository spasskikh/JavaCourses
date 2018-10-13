package com.task03.toys.model.data;

import com.task03.toys.model.enity.*;

public class DataSourcePlastic {

    public static ToyPlastic[] get() {
        return new ToyPlastic[]{
                new TPSoldier(100, "white", "AK-47", "male"),
                new TPSoldier(150, "black", "M-16", "female"),
                new TPSoldier(150, "green", "M-16", "male"),
                new TPSoldier(50, "green", "AK-47", "female"),
                new TPDinosaur(75, "green", Nutrition.CARNIVOROUS),
                new TPDinosaur(110, "green", Nutrition.OMNIVOROUS),
                new TPDinosaur(30, "green", Nutrition.HERBIVOROUS),
                new TPDinosaur(170, "green", Nutrition.HERBIVOROUS),
                new TPBall(10,"white"),
                new TPBall(15,"red"),
        };
    }
}
