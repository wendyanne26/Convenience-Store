package com.wendyConvenienceStore.services;

import com.wendyConvenienceStore.staff.Cashier;

import java.util.List;

public interface ManagerServices {
    void paySalaries(double amount);
    void hireCashier(List<Cashier> cashiers);
    void fireCashier(Cashier cashier);

}
