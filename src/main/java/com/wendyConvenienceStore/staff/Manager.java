package com.wendyConvenienceStore.staff;

import com.wendyConvenienceStore.Enum.Roles;
import com.wendyConvenienceStore.services.ManagerServices;
import com.wendyConvenienceStore.store.Store;

import java.util.List;

public class Manager extends Staff {
    ManagerServices managerServices;
   Store store;
    public Manager(String name, Roles roles, Store store, ManagerServices managerServices) {
        super(name, roles);
        this.store = store;
       this.managerServices = managerServices;
    }

    public void paySalaries(double amount) {
        managerServices.paySalaries(amount);

    }
    public void hireCashier(List<Cashier> cashiers){
        managerServices.hireCashier(cashiers);
        for(Cashier eachCashier: cashiers ){
            System.out.println("congratulations "+ eachCashier.getName()+ " your application has been approved");
        }

    }
    public void fireCashier(Cashier cashier){
        managerServices.fireCashier(cashier);
    }
}
