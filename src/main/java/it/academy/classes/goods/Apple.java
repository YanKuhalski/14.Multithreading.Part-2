package main.java.it.academy.classes.goods;

public class Apple implements Good {
    private int paraice = 5;
    private String name = "Яблоко";

    @Override
    public String print() {
        return " " + name + " - " + paraice + ",";
    }
}
