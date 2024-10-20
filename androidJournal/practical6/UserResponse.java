package com.example.yourapp;

import java.util.List;

public class UserResponse {
    private int page;
    private List<User> data;
    private int total_pages;
    private int total;

    // Getters
    public int getPage() {
        return page;
    }

    public List<User> getData() {
        return data;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public int getTotal() {
        return total;
    }
}
