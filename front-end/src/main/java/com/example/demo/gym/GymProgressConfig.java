package com.example.demo.gym;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GymProgressConfig {

    @Bean
    CommandLineRunner commandLineRunner(GymProgressRepository repository) {
        return args -> {
            // Example data for initialization
            GymProgress record1 = new GymProgress(
                    "Doanh Trinh",
                    LocalDate.of(2005, 2, 12),
                    "johndoe@example.com",
                    "Bench Press",
                    100.5,
                    10,
                    LocalDate.now());

            GymProgress record2 = new GymProgress(
                    "John Doe",
                    LocalDate.of(1995, 8, 20),
                    "johndoe@example.com",
                    "Squat",
                    150.0,
                    8,
                    LocalDate.now());

            repository.saveAll(List.of(record1, record2));
        };
    }
}
