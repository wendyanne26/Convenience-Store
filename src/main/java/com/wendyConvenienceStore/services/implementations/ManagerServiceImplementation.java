package com.wendyConvenienceStore.services.implementations;

import com.wendyConvenienceStore.services.ManagerServices;
import com.wendyConvenienceStore.staff.Cashier;
import com.wendyConvenienceStore.store.Store;

import java.util.List;

public class ManagerServiceImplementation implements ManagerServices {
    private Store store;

    public ManagerServiceImplementation(Store store) {
        this.store = store;
    }

    @Override
    public void paySalaries(double amount) {
        for(Cashier currentCashier : store.getCashiers()){
            currentCashier.setCashierAccount(currentCashier.getCashierAccount() + amount);
        }
    }

    @Override
    public void hireCashier(List<Cashier> cashiers) {
        store.setCashiers(cashiers);
    }

    @Override
    public void fireCashier(Cashier cashier) {

    }
}
