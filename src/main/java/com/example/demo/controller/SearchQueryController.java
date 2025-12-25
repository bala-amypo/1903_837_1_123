package com.example.demo.controller;

import com.example.demo.dto.EmployeeSearchRequest;
import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
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
    public List<Employee> search(@RequestBody EmployeeSearchRequest request,
                                 @RequestParam Long userId) {
        return service.searchEmployeesBySkills(request.getSkills(), userId);
    }

    @GetMapping("/{id}")
    public SearchQueryRecord get(@PathVariable Long id) {
        return service.getQueryById(id);
    }

    @GetMapping("/user/{userId}")
    public List<SearchQueryRecord> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }
}
