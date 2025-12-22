package com.example.demo.controller;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@Tag(name = "Search APIs")
public class SearchQueryController {

    private final SearchQueryService service;

    public SearchQueryController(SearchQueryService service) {
        this.service = service;
    }

    @PostMapping("/employees")
    public List<Object> searchEmployees(@RequestBody List<String> skills,
                                        @RequestParam Long userId) {
        return service.searchEmployeesBySkills(skills, userId);
    }

    @GetMapping("/{id}")
    public SearchQueryRecord getQuery(@PathVariable Long id) {
        return service.getQueryById(id);
    }

    @GetMapping("/user/{userId}")
    public List<SearchQueryRecord> getQueriesForUser(@PathVariable Long userId) {
        return service.getQueriesForUser(userId);
    }
}


