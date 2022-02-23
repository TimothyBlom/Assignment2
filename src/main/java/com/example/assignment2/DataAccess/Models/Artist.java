package com.example.assignment2.DataAccess.Models;

public class Artist {
    private String Name;

    public Artist() {

    }

    public Artist(String Name) {
        this.Name = Name;
    }

    public String getArtist() {
        return Name;
    }

    public void setArtist(String Name) {
        this.Name = Name;
    }
}