package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Repositories.ArtistRepository;
import com.example.assignment2.DataAccess.Repositories.GenreRepository;
import com.example.assignment2.DataAccess.Repositories.TrackRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    private final TrackRepository trackRepository = new TrackRepository();
    private final ArtistRepository artistRepository = new ArtistRepository();
    private final GenreRepository genreRepository = new GenreRepository();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePageView(Model model) {
        model.addAttribute("randomArtists", artistRepository.getRandomArtists(5));
        model.addAttribute("randomTracks", trackRepository.getRandomTracks(5));
        model.addAttribute("randomGenres", genreRepository.getRandomGenres(5));
        return "Home";
    }
}