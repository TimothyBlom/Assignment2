package com.example.assignment2.DataAccess.Models;

public class Song {
    private String songName;

    public Song() {

    }

    public Song(String songName) {
        this.songName = songName;
    }

    public String GetSongName() {
        return songName;
    }

    public void SetSongName(String songName) {
        this.songName = songName;
    }
}
