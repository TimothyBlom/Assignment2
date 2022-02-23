package com.example.assignment2.DataAccess.Models;

public class Genre {
    private String Name;

    public Genre() {

    }

    public Genre(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}