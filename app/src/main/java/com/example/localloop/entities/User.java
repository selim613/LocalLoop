package com.example.localloop.entities;

// *** Look into making User abstract, and making Admin a singleton class ***
public class User {
    protected String username;
    protected String role;

    // Constructor for the user class, it is invoked upon a successful login
    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Getters
    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }
}
