package app.fitnessapp.service;

import app.fitnessapp.model.Goals;
import org.springframework.stereotype.Service;

@Service
public interface GoalsService {

    Goals getUserByGoals(String email);
    void saveUserGoals(Goals goals);

}