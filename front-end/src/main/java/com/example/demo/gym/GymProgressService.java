package com.example.demo.gym;

import java.util.List;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class GymProgressService {

    private final GymProgressRepository gymProgressRepository;

    @Autowired
    public GymProgressService(GymProgressRepository gymProgressRepository) {
        this.gymProgressRepository = gymProgressRepository;
    }

    public List<GymProgress> getGymProgressRecords() {
        return gymProgressRepository.findAll();
    }

    public void addNewGymProgress(GymProgress gymProgress) {
        gymProgressRepository.save(gymProgress);
    }

    public void deleteGymProgress(Long progressId) {
        boolean exists = gymProgressRepository.existsById(progressId);
        if (!exists) {
            throw new IllegalStateException("Gym progress record with id " + progressId + " does not exist");
        }
        gymProgressRepository.deleteById(progressId);
    }

    @Transactional
    public void updateGymProgress(Long progressId, String exerciseName, double weight, int reps, LocalDate date) {
        GymProgress gymProgress = gymProgressRepository.findById(progressId)
            .orElseThrow(() -> new IllegalStateException("Gym progress record with id " + progressId + " does not exist"));

        if (exerciseName != null && !exerciseName.isEmpty() && !gymProgress.getExerciseName().equals(exerciseName)) {
            gymProgress.setExerciseName(exerciseName);
        }

        if (weight > 0 && gymProgress.getWeight() != weight) {
            gymProgress.setWeight(weight);
        }

        if (reps > 0 && gymProgress.getReps() != reps) {
            gymProgress.setReps(reps);
        }

        if (date != null && !gymProgress.getDate().equals(date)) {
            gymProgress.setDate(date);
        }
    }
}
