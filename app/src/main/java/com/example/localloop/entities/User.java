package com.example.localloop.entities;

// *** Look into making User abstract, and making Admin a singleton class ***
public class User {
    protected String name;
    protected String role;

    // Constructor for the user class, it is invoked upon a successful login
    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
}
