package com.example.demo.controller;

import com.example.demo.service.SearchQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@Tag(name = "Search")
public class SearchQueryController {

    private final SearchQueryService service;

    public SearchQueryController(SearchQueryService service) {
        this.service = service;
    }

    @PostMapping("/employees")
    public List<Employee> search(@RequestBody EmployeeSearchRequest req,
                                 @RequestParam Long userId) {
        return service.searchEmployeesBySkills(req.getSkills(), userId);
    }

    @GetMapping("/{id}")
    public SearchQueryRecord get(@PathVariable Long id) {
        return service.getQueryById(id);
    }

    @GetMapping("/user/{userId}")
    public List<SearchQueryRecord> getForUser(@PathVariable Long userId) {
        return service.getQueriesForUser(userId);
    }
}



