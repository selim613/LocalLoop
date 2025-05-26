package com.example.localloop.entities;

public class Participant extends User {
    public Participant(String name, String username, String password) {
        super(name, username, password, "participant");
    }
}
