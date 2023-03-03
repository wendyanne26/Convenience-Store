package com.wendyConvenienceStore.services.implementations;

import com.wendyConvenienceStore.customer.Customer;
import com.wendyConvenienceStore.services.CashierServices;
import com.wendyConvenienceStore.store.Product;
import com.wendyConvenienceStore.store.Store;

import java.util.ArrayList;
import java.util.List;

public class CashierServiceImplementation implements CashierServices {
    private final Store store;


    public CashierServiceImplementation(Store store) {
        this.store = store;
    }

    @Override
    public void checkoutCustomer(Customer customer) {
        double totalPrice = 0.0;
        List<Product> removeFromCart = new ArrayList<>();
        for (Product product : customer.getCustomerCart()) {
            if (isProductAvailable(product)) {
                totalPrice += product.getQuantity() * product.getPrice();
            }else{
                System.out.println("sorry " + product.getName() + " is out of stock");
                removeFromCart.add(product);
            }
        }
        customer.getCustomerCart().removeAll(removeFromCart);

        if (customer.getCustomerWallet() >= totalPrice) {
            for (Product product : customer.getCustomerCart()) {
                updateStoreStock(product, product.getQuantity());
            }
            customer.setCustomerWallet(customer.getCustomerWallet() - totalPrice);
            store.setStoreAccount(customer.getCustomerWallet() + totalPrice);
            System.out.println("Purchase successful");
            System.out.println("#######************* " + customer.getName() + "'s Receipt ***********#######");
            printReceipt(customer.getCustomerCart(), totalPrice);
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
            if (product.getName().equals(eachProduct.getName()) && product.getQuantity() <= eachProduct.getQuantity()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printReceipt(List<Product> customerCart, double totalPrice) {
        int index = 0;
        for (Product product : customerCart) {
            System.out.println(++index + " --- " + product.getName() + " --- " + product.getQuantity() + " units --- " + product.getPrice());
        }
        System.out.println(">>>>>>>> Total Price: $" + totalPrice + " <<<<<<<<<");
        System.out.println();
    }
}
