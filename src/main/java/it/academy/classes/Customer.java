package main.java.it.academy.classes;

import main.java.it.academy.classes.goods.Good;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Good> goodList = new ArrayList<>();

    public String print() {
        StringBuilder info = new StringBuilder().append("Покупатель :");
        for (Good good : goodList) {
            info.append(good.print());
        }
        return info.toString();
    }

    public Customer addGood(Good good) {
        goodList.add(good);
        return this;
    }

}
