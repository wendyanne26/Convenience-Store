package com.wendyConvenienceStore.Enum;

public enum Roles {
    MANAGER, CASHIER;

    @Override
    public String toString() {
        return switch(this){
            case MANAGER -> "manager";
            case CASHIER -> "cashier";
        };
    }
}
