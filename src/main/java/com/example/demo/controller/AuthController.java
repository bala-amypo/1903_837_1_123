package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider tokenProvider;
    private final EmployeeRepository employeeRepository;

    public AuthController(JwtTokenProvider tokenProvider,
                          EmployeeRepository employeeRepository) {
        this.tokenProvider = tokenProvider;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email) {

        Employee emp = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return tokenProvider.generateToken(
                emp.getId(),
                emp.getEmail(),
                "USER"
        );
    }
}
