package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.Artist;
import com.example.assignment2.DataAccess.Repositories.ArtistRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/Artist")
public class HomeController {
    private final ArtistRepository randomArtistRepository = new ArtistRepository();

    @GetMapping
    public ArrayList<Artist> getRandomArtist() {
        return randomArtistRepository.getArtist();
    }
}
