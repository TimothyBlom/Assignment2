package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Models.Customer;
import com.example.assignment2.DataAccess.Repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/customers")
public class SongsController {

    @GetMapping("songList")
    public String liistOfSongs() {
        return "songList";
    }
}