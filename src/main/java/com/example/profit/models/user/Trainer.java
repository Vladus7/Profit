package com.example.profit.models.user;

import com.example.profit.models.Workout;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Data
//public class Trainer extends User {
//    @OneToMany(mappedBy="trainer", fetch = FetchType.EAGER)
//    private List<Athlete> athletes;
//    @OneToMany(mappedBy="trainer", fetch = FetchType.EAGER)
//    private List<Workout> workouts;
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="administrator_id", nullable=false)
//    private Administrator administrator;
//}
