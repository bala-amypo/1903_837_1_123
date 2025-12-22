package com.example.demo.repository;

import com.example.demo.entity.SearchQueryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchQueryRecordRepository extends JpaRepository<SearchQueryRecord, Long> {
}
