package com.example.localloop;

public class User {
    private String username;
    private String role;

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
