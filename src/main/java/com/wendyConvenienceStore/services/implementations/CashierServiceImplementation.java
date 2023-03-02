package com.wendyConvenienceStore.services.implementations;

import com.wendyConvenienceStore.customer.Customer;
import com.wendyConvenienceStore.services.CashierServices;
import com.wendyConvenienceStore.store.Product;
import com.wendyConvenienceStore.store.Store;

public class CashierServiceImplementation implements CashierServices {
    private Store store;

    public CashierServiceImplementation(Store store) {
        this.store = store;
    }

    @Override
    public void checkoutCustomer(Customer customer) {
        double totalPrice = 0.0;
        for (Product product : customer.getCustomerCart()) {
            if (isProductAvailable(product)) {
                totalPrice += product.getQuantity() * product.getPrice();
            }else{
                System.out.println("sorry " + product.getName() + " is out of stock");
                customer.getCustomerCart().remove(product);
            }
        }
        if (customer.getCustomerWallet() >= totalPrice) {
            for (Product product : customer.getCustomerCart()) {
                updateStoreStock(product, product.getQuantity());
            }
            customer.setCustomerWallet(customer.getCustomerWallet() - totalPrice);
            store.setStoreAccount(customer.getCustomerWallet() + totalPrice);
        }
    }

    @Override
    public void updateStoreStock(Product product, int quantity) {
        for (Product currentProduct : store.getProductsInStore()) {
            if (currentProduct.getName().equals(product.getName()) && currentProduct.getQuantity() >= quantity) {
                currentProduct.setQuantity(currentProduct.getQuantity() - quantity);
                break;
            }
        }
    }

    @Override
    public boolean isProductAvailable(Product product) {
        for (Product eachProduct : store.getProductsInStore()) {
            if (product.getName().equals(eachProduct.getName()) && product.getQuantity() >= eachProduct.getQuantity()) {
                return true;
            }
        }
        return false;
    }
}
