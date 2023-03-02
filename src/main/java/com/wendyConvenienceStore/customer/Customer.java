package com.wendyConvenienceStore.customer;

import com.wendyConvenienceStore.store.Product;

import java.util.List;

public class Customer {
    private double customerWallet;
    private List<Product> customerCart;

    public Customer(double customerWallet, List<Product> products) {
        this.customerWallet = customerWallet;
        this.customerCart = products;
    }

    public double getCustomerWallet() {
        return customerWallet;
    }

    public List<Product> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerWallet(double customerWallet) {
        this.customerWallet = customerWallet;
    }
}
