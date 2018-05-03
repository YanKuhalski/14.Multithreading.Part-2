package main.java.it.academy.classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CashPoint {
    private final CustomerQueue customerQueue;

    public CashPoint(CustomerQueue customerQueue) {
        this.customerQueue = customerQueue;
    }

    public void serve() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i < 3; i++) {
            executorService.submit(new CashPointRunnable());
        }
    }

    public class CashPointRunnable implements Runnable {
        public void run() {
            while (true) {
                Customer customer = null;
                customer = customerQueue.getCustomer();
                if (customer != null) {
                    System.out.printf(Thread.currentThread().getName() + " " + customer.print() + "\n");
                } else {
                    synchronized (customerQueue) {
                        try {
                            customerQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
