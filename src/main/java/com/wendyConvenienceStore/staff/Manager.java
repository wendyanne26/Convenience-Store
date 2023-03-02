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

    }
    public void hireCashier(List<Cashier> cashiers){

    }
    public void fireCashier(Cashier cashier){

    }
}
