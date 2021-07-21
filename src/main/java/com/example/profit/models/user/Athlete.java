package com.example.profit.models.user;

import com.example.profit.models.Exercise;
import com.example.profit.models.Workout;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Data
//public class Athlete extends User {
//    @OneToMany(mappedBy="trainer", fetch = FetchType.EAGER)
//    private List<Workout> workouts;
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="trainer_id")
//    private Trainer trainer;
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="administrator_id")
//    private Administrator administrator;
//}
