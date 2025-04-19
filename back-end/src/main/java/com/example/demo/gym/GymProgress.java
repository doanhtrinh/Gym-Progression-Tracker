package com.example.demo.gym;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class GymProgress {
    @Id
    @SequenceGenerator(
        name = "gym_progress_sequence",
        sequenceName = "gym_progress_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "gym_progress_sequence"
    )
    private Long id;
    private String name;
    private LocalDate dob;
    private String email;
    
    @Transient
    private Integer age;
    
    private String exerciseName;
    private double weight;
    private int reps;
    private LocalDate date;

    public GymProgress() {
    }

    public GymProgress(String name, LocalDate dob, String email, String exerciseName, double weight, int reps, LocalDate date) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.reps = reps;
        this.date = date;
    }

    public GymProgress(Long id, String name, LocalDate dob, String email, String exerciseName, double weight, int reps, LocalDate date) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.reps = reps;
        this.date = date;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getExerciseName() {
        return exerciseName;
    }
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public int getReps() {
        return reps;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GymProgress [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", email=" + email + ", exerciseName=" + exerciseName + ", weight=" + weight + ", reps=" + reps + ", date=" + date + "]";
    }
}
