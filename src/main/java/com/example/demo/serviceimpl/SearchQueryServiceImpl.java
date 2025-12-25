package com.example.demo.serviceimpl;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository searchRepo;
    private final EmployeeSkillRepository esRepo;

    public SearchQueryServiceImpl(SearchQueryRecordRepository searchRepo,
                                  EmployeeSkillRepository esRepo) {
        this.searchRepo = searchRepo;
        this.esRepo = esRepo;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {

        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("Skills list must not be empty");
        }

        // ✅ normalize skills
        List<String> normalizedSkills = skills.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        // ✅ repository call (3 PARAMETERS – IMPORTANT)
        List<Employee> result = esRepo.findEmployeesByAllSkillNames(
                normalizedSkills,
                searcherId,
                Long.valueOf(normalizedSkills.size())
        );

        // ✅ persist search query
        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(searcherId);
        record.setSkillsRequested(String.join(",", normalizedSkills));
        record.setResultsCount(result.size());
        searchRepo.save(record);

        return result;
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        return searchRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Query not found"));
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long userId) {
        return searchRepo.findBySearcherId(userId);
    }

    @Override
    public void saveQuery(SearchQueryRecord record) {
        searchRepo.save(record);
    }
}
