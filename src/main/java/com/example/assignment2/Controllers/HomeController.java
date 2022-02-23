package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.Song;
import com.example.assignment2.DataAccess.Models.Customer;
import com.example.assignment2.DataAccess.Repositories.SongRepository;
import com.example.assignment2.DataAccess.Repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
//@Controller
@RequestMapping("/songs")
public class HomeController {
    private final SongRepository SongRepository = new SongRepository();
    private final CustomerRepository customerRepository = new CustomerRepository();

//Only works with @RestController
    @GetMapping
    public ArrayList<Song> getAllTracks() {
        return SongRepository.getAllTracks();
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