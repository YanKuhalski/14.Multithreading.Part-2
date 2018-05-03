package main.java.it.academy.classes.goods;

public class Meat implements Good {
    private int paraice = 35;
    private String name = "Мясо";

    @Override
    public String print() {
        return " " + name + " - " + paraice + ",";
    }
}
