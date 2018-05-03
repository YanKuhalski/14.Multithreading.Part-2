package main.java.it.academy.classes.goods;

public class Cheese implements Good {
    private int paraice = 15;
    private String name = "Сыр";

    @Override
    public String print() {
        return " " + name + " - " + paraice + ",";
    }
}
