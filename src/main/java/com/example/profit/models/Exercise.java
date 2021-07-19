package com.example.profit.models;

import lombok.Data;

import java.util.List;

@Data
public class Exercise {
    private long id;
    private String name;
    private List<SuperSet> superSets;
    private Workout workout;

    public Exercise() {
    }

    public Exercise(String name, List<SuperSet> superSets) {
        this.name = name;
        this.superSets = superSets;
    }

    public Exercise(long id, String name, List<SuperSet> superSets, Workout workout) {
        this.id = id;
        this.name = name;
        this.superSets = superSets;
        this.workout = workout;
    }
}
