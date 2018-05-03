package main.java.it.academy.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class CustomerQueue {
    private Queue<Customer> customerQueue = new LinkedList<>();
    private BlockingQueue<Customer> customerBlockingQueue = new LinkedBlockingQueue<>();
    private ReentrantLock lock = new ReentrantLock();
    private Semaphore semaphore = new Semaphore(1);
    private int methodCounter = 1;

    public CustomerQueue addCustomer(Customer customer) {
        customerQueue.add(customer);
        return this;
    }

    public Customer getCustomerUsingLock() {
        Customer customer;
        lock.lock();
        customer = customerQueue.poll();
        methodCounter++;
        lock.unlock();
        return customer;
    }

    public Customer getCustomerUsingSemaphore() {
        Customer customer = null;
        try {
            semaphore.acquire();
            customer = customerQueue.poll();
            methodCounter++;
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Customer getCustomerUsingBlockingQueue() {
        Customer customer = null;
        synchronized (customerQueue) {

            try {
                customerBlockingQueue.addAll(customerQueue);
                customer = customerBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customerQueue.remove(customer);
            customerBlockingQueue.clear();
            methodCounter = 1;
        }
        return customer;
    }

    public Customer getCustomer() {
        Customer customer = null;

        switch (methodCounter) {
            case 1:
                customer = getCustomerUsingLock();
                break;
            case 2:
                customer = getCustomerUsingSemaphore();

                break;
            case 3:
                customer = getCustomerUsingBlockingQueue();
                break;
        }
        return customer;
    }
}

