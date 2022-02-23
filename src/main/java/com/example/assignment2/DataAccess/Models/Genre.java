package com.example.assignment2.DataAccess.Models;

public class Genre {
    private String Name;

    public Genre() {

    }

    public Genre(String Name) {
        this.Name = Name;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }
}