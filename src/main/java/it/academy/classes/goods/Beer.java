package main.java.it.academy.classes.goods;

public class Beer implements Good {
    private int paraice = 30;
    private String name = "Пиво";

    @Override
    public String print() {
        return " " + name + " - " + paraice + ",";
    }
}
