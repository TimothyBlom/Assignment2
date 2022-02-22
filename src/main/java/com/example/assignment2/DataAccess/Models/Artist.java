package com.example.assignment2.DataAccess.Models;

public class Artist {
    private String artistName;

    public Artist() {

    }

    public Artist(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}