package com.example.demo.util;

import java.util.List;

public class ProficiencyValidator {

    private static final List<String> LEVELS =
            List.of("Beginner", "Intermediate", "Advanced", "Expert");

    public static void validate(String level) {
        if (!LEVELS.contains(level)) {
            throw new IllegalArgumentException("Invalid proficiency");
        }
    }
}
