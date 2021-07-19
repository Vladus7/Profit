package com.example.profit.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Workout {
    private long id;
    private String name;
    private String descriptions;
    private LocalDate date;
    private String review;
    private List<Exercise> exercises;

    public Workout() {
    }

    public Workout(String name, String descriptions, LocalDate date, String review, List<Exercise> exercises) {
        this.name = name;
        this.descriptions = descriptions;
        this.date = date;
        this.review = review;
        this.exercises = exercises;
    }

    public Workout(long id, String name, String descriptions, LocalDate date, String review, List<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.date = date;
        this.review = review;
        this.exercises = exercises;
    }
}
