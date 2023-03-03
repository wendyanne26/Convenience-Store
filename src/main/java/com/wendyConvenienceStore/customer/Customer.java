package com.wendyConvenienceStore.customer;

import com.wendyConvenienceStore.services.CustomerServices;
import com.wendyConvenienceStore.store.Product;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Customer implements CustomerServices {
    private double customerWallet;
    private final List<Product> customerCart;
    private String name;
    private final String arrivalTime;

    public Customer(String name, double customerWallet) {
        this.customerWallet = customerWallet;
        this.name = name;
        this.arrivalTime = String.valueOf(LocalTime.now());
        this.customerCart = new ArrayList<>();
    }

    public double getCustomerWallet() {
        return customerWallet;
    }

    public void setCustomerWallet(double customerWallet) {
        this.customerWallet = customerWallet;
    }
    @Override
    public List<Product> getCustomerCart() {
        return customerCart;
    }
    @Override
    public void selectProducts(Product product, int quantity) {
        Product selectedProduct = new Product(product.getName(), product.getPrice(), quantity);
        customerCart.add(selectedProduct);
    }

    public String getName() {
        return name;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}
