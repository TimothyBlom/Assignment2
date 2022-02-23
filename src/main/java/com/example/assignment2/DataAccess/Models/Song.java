package com.example.assignment2.DataAccess.Models;

public class Song {
    private String track;

    public Song() {

    }

    public Song(String track) {
        this.track = track;
    }

    public String GetTrack() {
        return track;
    }

    public void SetTrack(String track) {
        this.track = track;
    }
}
