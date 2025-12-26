package com.example.demo.model;

public class SearchQueryRecord {

    private Long id;
    private String keyword;
    private Long employeeId;

    public SearchQueryRecord() {
    }

    public SearchQueryRecord(Long id, String keyword, Long employeeId) {
        this.id = id;
        this.keyword = keyword;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
