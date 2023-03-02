package com.wendyConvenienceStore.store;

import com.wendyConvenienceStore.staff.Cashier;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> productsInStore;
    private final String name;
    private double storeAccount;
    private List<Cashier> cashiers;
    public Store(List<Product> productsInStore, String name) {
        this.productsInStore = productsInStore;
        this.name = name;
    }

    public List<Product> getProductsInStore() {
        return productsInStore;
    }

    public String getName() {
        return name;
    }

    public void setProductsInStore(List<Product> productsInStore) {
        this.productsInStore = productsInStore;
    }

    public double getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(double storeAccount) {
        this.storeAccount = storeAccount;
    }

    public void setCashiers(List<Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }
}
