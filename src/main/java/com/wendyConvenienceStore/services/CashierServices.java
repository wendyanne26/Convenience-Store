package com.wendyConvenienceStore.services;

import com.wendyConvenienceStore.customer.Customer;
import com.wendyConvenienceStore.store.Product;

import java.util.List;

public interface CashierServices {
    void checkoutCustomer(Customer customer);
    void updateStoreStock(Product product, int quantity);
    boolean isProductAvailable(Product product);
    void printReceipt(List<Product> cart, double totalPrice);
}
