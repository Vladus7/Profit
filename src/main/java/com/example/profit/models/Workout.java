package com.example.profit.models;

//import com.example.profit.models.user.Administrator;
//import com.example.profit.models.user.Trainer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descriptions;
    private LocalDate date;
    private String review;
    @OneToMany(mappedBy="workout", fetch = FetchType.EAGER)
    private List<Exercise> exercises;
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="administrator_id", nullable=true)
//    private Administrator administrator;
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="trainer_id", nullable=true)
//    private Trainer trainer;

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
