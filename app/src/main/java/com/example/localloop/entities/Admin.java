package com.example.localloop.entities;

public class Admin extends User {
    public Admin(String name, String role) {
        super(name,"admin");
    }

    public void addCategory() {

    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getRole() {
        return super.getRole();
    }
}


