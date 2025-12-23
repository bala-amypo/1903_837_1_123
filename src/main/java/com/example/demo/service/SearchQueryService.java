package com.example.demo.service;

import com.example.demo.entity.SearchQueryRecord;
import java.util.List;

public interface SearchQueryService {
    List<Object> search(List<String> skills, Long userId);
    SearchQueryRecord get(Long id);
    List<SearchQueryRecord> getByUser(Long userId);
}
