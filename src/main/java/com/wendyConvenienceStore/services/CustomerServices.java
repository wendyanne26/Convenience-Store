package com.wendyConvenienceStore.services;

import com.wendyConvenienceStore.store.Product;

import java.util.List;

public interface CustomerServices {
    void selectProducts(Product product, int quantity);
    List<Product> getCustomerCart();
}
