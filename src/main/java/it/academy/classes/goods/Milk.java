package main.java.it.academy.classes.goods;

public class Milk implements Good {
    private int paraice = 20;
    private String name = "Молоко";

    @Override
    public String print() {
        return " " + name + " - " + paraice + ",";
    }
}

