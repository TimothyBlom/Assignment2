package com.example.assignment2.Controllers;

import com.example.assignment2.DataAccess.Repositories.SearchResultRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    private final SearchResultRepository searchResultRepository = new SearchResultRepository();

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPageView(@RequestParam String query, Model model) {
        model.addAttribute("searchResults", searchResultRepository.getSearchResults(query));
        return "Search";
    }
}
