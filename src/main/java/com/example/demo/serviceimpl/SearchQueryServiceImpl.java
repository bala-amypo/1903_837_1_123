package com.example.demo.serviceimpl;

import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository repo;

    public SearchQueryServiceImpl(SearchQueryRecordRepository repo) {
        this.repo = repo;
    }

    public List<Object> search(List<String> skills, Long userId) {
        SearchQueryRecord r = new SearchQueryRecord();
        r.setUserId(userId);
        r.setSkills(skills.toString());
        r.setResultCount(0);
        repo.save(r);
        return List.of();
    }

    public SearchQueryRecord get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<SearchQueryRecord> getByUser(Long userId) {
        return repo.findAll();
    }
}
