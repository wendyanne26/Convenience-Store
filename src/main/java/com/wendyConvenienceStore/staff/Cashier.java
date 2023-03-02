package com.wendyConvenienceStore.staff;

import com.wendyConvenienceStore.Enum.Roles;
import com.wendyConvenienceStore.customer.Customer;
import com.wendyConvenienceStore.services.CashierServices;
import com.wendyConvenienceStore.store.Product;

import java.util.PriorityQueue;
import java.util.Queue;

public class Cashier extends Staff{
    private final Queue<Customer> customerQueue;
    CashierServices cashierServices;
    private double cashierAccount = 0.0;

    public Cashier(String name, Roles roles, CashierServices cashierServices) {
        super(name, roles);
        this.customerQueue = new PriorityQueue<>();
        this.cashierServices = cashierServices;
    }
    public void checkoutCustomer(Customer customer){
        cashierServices.checkoutCustomer(customer);
    }
    public void updateStoreStock(Product product, int quantity){
        cashierServices.updateStoreStock(product, quantity);
    }
    public void isProductAvailable(Product product){
        cashierServices.isProductAvailable(product);
    }

    public double getCashierAccount() {
        return cashierAccount;
    }

    public void setCashierAccount(double cashierAccount) {
        this.cashierAccount = cashierAccount;
    }

}
