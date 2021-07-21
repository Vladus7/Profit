package com.example.profit.controller;
//import com.example.jpa.exception.ResourceNotFoundException;
//import com.example.jpa.model.Post;
//import com.example.jpa.repository.PostRepository;

import com.example.profit.dao.ExerciseDao;
import com.example.profit.dao.SuperSetDao;
import com.example.profit.dao.WorkoutDao;
import com.example.profit.models.Exercise;
import com.example.profit.models.SuperSet;
import com.example.profit.models.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import javax.validation.Valid;

//@RestController
public class PostController {

//    @Autowired
//    private PostRepository postRepository;

    @Autowired
    private WorkoutDao workoutDao;
    @Autowired
    private SuperSetDao setDao;
    @Autowired
    private ExerciseDao exerciseDao;

    @GetMapping("/workout")
    public List<Workout> getAllPosts() {
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
        return workoutDao.findAll();
    }

//    @PostMapping("/posts")
//    public Post createPost(@Valid @RequestBody Post post) {
//        return postRepository.save(post);
//    }
//
//    @PutMapping("/posts/{postId}")
//    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
//        return postRepository.findById(postId).map(post -> {
//            post.setTitle(postRequest.getTitle());
//            post.setDescription(postRequest.getDescription());
//            post.setContent(postRequest.getContent());
//            return postRepository.save(post);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }
//
//
//    @DeleteMapping("/posts/{postId}")
//    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
//        return postRepository.findById(postId).map(post -> {
//            postRepository.delete(post);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }

}