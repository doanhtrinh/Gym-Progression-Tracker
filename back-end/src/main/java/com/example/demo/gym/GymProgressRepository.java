package com.example.demo.gym;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface GymProgressRepository extends JpaRepository<GymProgress, Long> {
    
    @Query("SELECT g FROM GymProgress g WHERE g.email = ?1")
    Optional<GymProgress> findGymProgressByEmail(String email);
}