package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.Artist;
import com.example.assignment2.DataAccess.Models.Genre;
import com.example.assignment2.DataAccess.Models.Track;
import com.example.assignment2.DataAccess.Repositories.ArtistRepository;
import com.example.assignment2.DataAccess.Repositories.GenreRepository;
import com.example.assignment2.DataAccess.Repositories.TrackRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@Controller
//@RestController
@RequestMapping("/songs")
public class HomeController {
    private final TrackRepository trackRepository = new TrackRepository();
    private final ArtistRepository artistRepository = new ArtistRepository();
    private final GenreRepository genreRepository = new GenreRepository();

    @GetMapping("/tracks")
    public ArrayList<Track> getTracks() {
        return trackRepository.getTracks();
    }

    @GetMapping("/artists")
    public ArrayList<Artist> getArtist() {
        Collections.shuffle(artistRepository.getArtists());
        return artistRepository.getArtists();
    }

    @GetMapping("/genres")
    public ArrayList<Genre> getGenres() {
        return genreRepository.getGenres();
    }

    @GetMapping("/home")
    public String homePageView() {
        return "Home";
    }

    @GetMapping("/search")
    public String searchPageView() {
        return "Search";
    }

}