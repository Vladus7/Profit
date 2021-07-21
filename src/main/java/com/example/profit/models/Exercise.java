package com.example.profit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy="exercise", fetch = FetchType.EAGER)
    private List<SuperSet> superSets;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="workout_id", nullable=false)
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
