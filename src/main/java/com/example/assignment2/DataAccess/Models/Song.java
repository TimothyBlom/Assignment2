package com.example.assignment2.DataAccess.Models;

public class Song {
    private String Name;

    public Song() {

    }

    public Song(String Name) {
        this.Name = Name;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }
}
