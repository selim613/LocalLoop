package com.example.localloop.events;

import java.util.ArrayList;

// Managed by admin
public class Category {
    private String name;
    private String description;
    private static ArrayList<String> categories = new ArrayList<>();    // This will track all categories, will be useful for error handling

    public Category(String name, String description) {
        this.name = name;
        categories.add(name);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<String> getCategories() {
        return categories;
    }

    /*
    category.add("First");
    category.add("Second");
    String first = category.get(0);
    category.set(0, "Updated First");
    category.remove(1); // Removes Second
    */
}
