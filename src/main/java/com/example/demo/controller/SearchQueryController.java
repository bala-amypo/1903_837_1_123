package com.example.demo.controller;

import com.example.demo.service.SearchQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    private final SearchQueryService service;

    public SearchQueryController(SearchQueryService service) {
        this.service = service;
    }

    @PostMapping("/employees")
    public List<Object> search(@RequestBody List<String> skills,
                               @RequestParam Long userId) {
        return service.search(skills, userId);
    }
}


