package app.fitnessapp.repository;

import app.fitnessapp.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<List<WorkoutPlan>, Long> {
    List<WorkoutPlan> findByName(String name);
}
