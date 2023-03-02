package com.wendyConvenienceStore.services;

import com.wendyConvenienceStore.customer.Customer;
import com.wendyConvenienceStore.store.Product;

public interface CashierServices {
    void checkoutCustomer(Customer customer);
    void updateStoreStock(Product product, int quantity);
    boolean isProductAvailable(Product product);
}
