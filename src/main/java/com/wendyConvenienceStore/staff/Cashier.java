package com.wendyConvenienceStore.staff;

import com.wendyConvenienceStore.Enum.Roles;
import com.wendyConvenienceStore.customer.Customer;
import com.wendyConvenienceStore.services.CashierServices;
import com.wendyConvenienceStore.store.Product;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cashier extends Staff {
    Queue<Customer> customerQueue;
    CashierServices cashierServices;
    private double cashierAccount = 0.0;

    public Cashier(String name, Roles roles, CashierServices cashierServices) {
        super(name, roles);
        this.customerQueue = new PriorityQueue<>(Comparator.comparing(Customer::getArrivalTime));
        this.cashierServices = cashierServices;
    }public Cashier(String name, Roles roles, CashierServices cashierServices, Comparator<Customer> cartSizeComparator) {
        super(name, roles);
        this.customerQueue = new PriorityQueue<>(cartSizeComparator);
        this.cashierServices = cashierServices;
    }

    public void checkoutCustomer(Customer customer) {
        cashierServices.checkoutCustomer(customer);
    }

    public void updateStoreStock(Product product, int quantity) {
        cashierServices.updateStoreStock(product, quantity);
    }

    public void isProductAvailable(Product product) {
        cashierServices.isProductAvailable(product);
    }

    public double getCashierAccount() {
        return cashierAccount;
    }

    public void setCashierAccount(double cashierAccount) {
        this.cashierAccount = cashierAccount;
    }

    public void addCustomerToQueue(Customer customer) {
        this.customerQueue.offer(customer);
        System.out.println(customer.getName() + " has been added to the queue");
    }

    public void attendToQueue() {
        Customer nextCustomer;
        while (!customerQueue.isEmpty()) {
            nextCustomer = customerQueue.poll();
            System.out.println(this.getName() + " is attending to " + nextCustomer.getName());
            checkoutCustomer(nextCustomer);
            System.out.println("customer queue " + customerQueue);
        }
        System.out.println("customer queue is empty");
    }

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }
}

