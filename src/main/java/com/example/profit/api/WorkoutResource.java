package com.example.profit.api;

import com.example.profit.dao.ExerciseDao;
import com.example.profit.dao.SuperSetDao;
import com.example.profit.dao.WorkoutDao;
import com.example.profit.models.Exercise;
import com.example.profit.models.SuperSet;
import com.example.profit.models.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Service
@Path("/")
public class WorkoutResource {
    @Autowired
    private WorkoutDao workoutDao;
    @Autowired
    private SuperSetDao setDao;
    @Autowired
    private ExerciseDao exerciseDao;

    @GET
    @Path("/workout")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response getAllWorkouts(){
        SuperSet set = new SuperSet(20.2, 14);
        SuperSet set1 = new SuperSet(10.2, 94);
        SuperSet set2 = new SuperSet(20.2, 14);
        SuperSet set3 = new SuperSet(10.2, 94);
        Exercise exercise = new Exercise("up",  new ArrayList<>(Arrays.asList(set, set1)));
        Exercise exercise1 = new Exercise("sit",  new ArrayList<>(Arrays.asList(set3, set2)));
        Workout workout = new Workout("Ноги", "dasfads", LocalDate.now(),
                "adfasfgfdasgv fsdbasdksdfjgijmdfbvms",
                new ArrayList<>(Arrays.asList(exercise, exercise1)));
        workoutDao.create(workout);
        exercise.setWorkout(workout);
        exerciseDao.create(exercise);
        exercise1.setWorkout(workout);
        exerciseDao.create(exercise1);
        set1.setExercise(exercise);
        set.setExercise(exercise);
        setDao.create(set);
        setDao.create(set1);

        set2.setExercise(exercise1);
        set3.setExercise(exercise1);
        setDao.create(set2);
        setDao.create(set3);
        return Response.ok(workoutDao.findAll()).build();
    }
}
