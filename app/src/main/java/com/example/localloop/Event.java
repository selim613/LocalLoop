package com.example.localloop;

public class Event {
    private String title;
    private String description;
    private String category;
    private String dataAndTime;
    private String location;
    private final int MAX_PARTICIPANTS;

    // Create class variable of type list to store event instances

    public Event(String title, String description, String category, String dataAndTime, String location, int maxParticipants) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.dataAndTime = dataAndTime;
        this.location = location;
        MAX_PARTICIPANTS = maxParticipants;
    }

    public int getNumParticipants() {

    }

    public void addParticipant() {

    }

    public void pastEvents() {

    }
}
