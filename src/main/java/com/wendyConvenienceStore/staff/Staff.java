package com.wendyConvenienceStore.staff;

import com.wendyConvenienceStore.Enum.Roles;

public abstract class Staff {
    private final String name;
    private String staffID;
    private static int ID = 100;

    public Staff(String name, Roles roles) {
        this.name = name;
        this.staffID = generateStaffId(roles);
    }

    public String getName() {
        return name;
    }

    public String getStaffID() {
        return staffID;
    }
    protected String generateStaffId(Roles roles ){
        String firstChar;
        if(roles.toString().equals("manager")){
            firstChar = "M";
        }else{
            firstChar = "C";
        }
        this.staffID = firstChar + ID++;
        return staffID;
    }
}
