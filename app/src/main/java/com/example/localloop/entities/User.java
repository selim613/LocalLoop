package com.example.localloop.entities;

public abstract class User {
    protected String name;
    protected String username;
    protected String role;

    // Constructor class
    public User(String name, String username, String role) {
        this.name = name;
        this.username = username;
        this.role = role;
    }

    // Getters for the attributes
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }
}
