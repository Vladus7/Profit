package com.example.profit.models.user;

import com.example.profit.models.Workout;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

//@Entity
//@Data
//public class Administrator extends User {
//    @OneToMany(mappedBy="administrator", fetch = FetchType.EAGER)
//    private List<Trainer> trainers;
//    @OneToMany(mappedBy="administrator", fetch = FetchType.EAGER)
//    private List<Athlete> athletes;
//    @OneToMany(mappedBy="administrator", fetch = FetchType.EAGER)
//    private List<Workout> workouts;
//}
