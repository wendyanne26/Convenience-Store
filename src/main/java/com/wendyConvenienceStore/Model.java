package com.wendyConvenienceStore;

import com.wendyConvenienceStore.Enum.Roles;
import com.wendyConvenienceStore.customer.Customer;
import com.wendyConvenienceStore.services.CashierServices;
import com.wendyConvenienceStore.services.CustomerServices;
import com.wendyConvenienceStore.services.ManagerServices;
import com.wendyConvenienceStore.services.implementations.CashierServiceImplementation;
import com.wendyConvenienceStore.services.implementations.CustomerComparator;
import com.wendyConvenienceStore.services.implementations.ManagerServiceImplementation;
import com.wendyConvenienceStore.staff.Cashier;
import com.wendyConvenienceStore.staff.Manager;
import com.wendyConvenienceStore.store.Product;
import com.wendyConvenienceStore.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static void main(String[] args) {
        Product product = new Product("Yam", 100.00, 20);
        Product product1 = new Product("Rice", 500.00, 12);
        Product product2 = new Product("Beans", 1300.00, 10);
        Product product3 = new Product("Indomie", 500.00, 15);


        Store store = new Store(new ArrayList<>(List.of(product, product1, product2, product3)), "OneStopShop");
        ManagerServices managerServices = new ManagerServiceImplementation(store);
        Manager manager = new Manager("Nte", Roles.MANAGER, store, managerServices);


        CashierServices cashierServices = new CashierServiceImplementation(store);
        CustomerComparator customerComparator = new CustomerComparator();
        Cashier cashier = new Cashier("Sophie", Roles.CASHIER, cashierServices);
        Cashier cashier1 = new Cashier("Stella", Roles.CASHIER, cashierServices, customerComparator);
        manager.hireCashier(new ArrayList<>(List.of(cashier, cashier1)));

        System.out.println(manager.getName() + " has hired " + cashier1.getName() + " and " + cashier.getName());

        Customer customer1 = new Customer("Joy", 100000);
        Customer customer2 = new Customer("John", 200000);
        Customer customer3 = new Customer("Jessy", 100000);
        Customer customer4 = new Customer("Juliet", 150000);


        System.out.println(("****************************************************"));


        customer1.selectProducts(product1, 2);
        System.out.println(customer1.getCustomerCart());
        customer2.selectProducts(product, 4);
        System.out.println(customer2.getCustomerCart());
        customer3.selectProducts(product2, 5);
        customer4.selectProducts(product3, 10);
//
        cashier.addCustomerToQueue(customer1);
        cashier.addCustomerToQueue(customer2);
        cashier.addCustomerToQueue(customer3);
        cashier.addCustomerToQueue(customer4);
//
        System.out.println(cashier.getName() + " has started attending to the queue... ");
        cashier.attendToQueue();
//        System.out.println("Size: " + customer1.getCustomerCart().size());
    }
}
