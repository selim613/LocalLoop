package com.example.localloop.entities;

import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

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


