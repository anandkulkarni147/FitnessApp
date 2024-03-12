package app.fitnessapp.service;

import app.fitnessapp.model.Goals;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoalsService {

    Goals getUserByGoals(String email);

    void saveUserGoals(Goals goals);

    List<Goals> getAllGoalsByEmail(String email);

}