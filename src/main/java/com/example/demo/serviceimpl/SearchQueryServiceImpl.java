package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SearchQueryService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository repo;
    private final EmployeeSkillRepository esRepo;

    public SearchQueryServiceImpl(SearchQueryRecordRepository repo,
                                  EmployeeSkillRepository esRepo) {
        this.repo = repo;
        this.esRepo = esRepo;
    }

    public void saveQuery(SearchQueryRecord r) {
        repo.save(r);
    }

    public List<Employee> searchEmployeesBySkills(List<String> skills, Long userId) {

        if (skills == null || skills.isEmpty())
            throw new IllegalArgumentException("must not be empty");

        List<String> normalized = skills.stream()
                .map(s -> s.trim().toLowerCase())
                .distinct()
                .collect(Collectors.toList());

        List<Employee> result =
                esRepo.findEmployeesByAllSkillNames(normalized, (long) normalized.size());

        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(userId);
        record.setSkillsRequested(String.join(",", normalized));
        record.setResultsCount(result.size());
        repo.save(record);

        return result;
    }

    public SearchQueryRecord getQueryById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
public List<SearchQueryRecord> getByUser(Long userId) {
    return repo.findBySearcherId(userId);
}

}
