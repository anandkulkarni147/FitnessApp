package app.fitnessapp.service;

import app.fitnessapp.model.WorkoutPlan;
import app.fitnessapp.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    public List<WorkoutPlan> getWorkoutPlans(String planName) {
        // Retrieve workout plan logic
        return workoutPlanRepository.findByName(planName);
    }
}
