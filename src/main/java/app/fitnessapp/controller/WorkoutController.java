package app.fitnessapp.controller;

import app.fitnessapp.model.WorkoutPlan;
import app.fitnessapp.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/plans")
    public ResponseEntity<List<WorkoutPlan>> getWorkoutPlans(@RequestParam String username) {
        List<WorkoutPlan> plans = workoutService.getWorkoutPlans(username);
        return ResponseEntity.ok(plans);
    }
}
