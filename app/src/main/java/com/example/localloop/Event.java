package com.example.localloop;

public class Event {
    private String title;
    private String description;
    private String category;
    private String dataAndTime;
    private String location;
    private int numParticipants;
    private final int MAX_PARTICIPANTS;  // Set later

    public Event(String title, String description, String category, String dataAndTime, String location, int maxParticipants) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.dataAndTime = dataAndTime;
        this.location = location;
        MAX_PARTICIPANTS = maxParticipants;
    }

    public int getNumParticipants() {
        return numParticipants;
    }
    public void manageParticipants() {

    }

    public void pastEvents() {

    }
}
