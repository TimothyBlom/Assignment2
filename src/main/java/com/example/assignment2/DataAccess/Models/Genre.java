package com.example.assignment2.DataAccess.Models;

public class Genre {
    private String genreName;

    public Genre() {

    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public String GetGenreName() {
        return genreName;
    }

    public void SetGenreName(String genreName) {
        this.genreName = genreName;
    }
}