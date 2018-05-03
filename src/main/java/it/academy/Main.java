package main.java.it.academy;

import main.java.it.academy.classes.CashPoint;
import main.java.it.academy.classes.Customer;
import main.java.it.academy.classes.CustomerQueue;
import main.java.it.academy.classes.goods.*;

public class Main {
    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue()
                .addCustomer(new Customer()
                        .addGood(new Cheese())
                        .addGood(new Milk()))
                .addCustomer(new Customer()
                        .addGood(new Milk())
                        .addGood(new Cheese())
                        .addGood(new Apple()))
                .addCustomer(new Customer()
                        .addGood(new Milk())
                        .addGood(new Apple())
                        .addGood(new Meat()))
                .addCustomer(new Customer()
                        .addGood(new Beer()))
                .addCustomer(new Customer()
                        .addGood(new Beer())
                        .addGood(new Meat()));
        CashPoint cashPoint = new CashPoint(customerQueue);
        cashPoint.serve();
    }
}

