package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.Song;
import com.example.assignment2.DataAccess.Repositories.SongRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//@RestController
@Controller
@RequestMapping("/songs")
public class HomeController {
    private final SongRepository SongRepository = new SongRepository();

    @GetMapping
    public ArrayList<Song> getTracks() {
        return SongRepository.getTracks();
    }

//Only works with @Controller
    @GetMapping("/home")
    public String homePageView() {
        return "Home";
    }

    @GetMapping("/search")
    public String searchPageView() {
        return "Search";
    }

}