package app.fitnessapp.service;

import app.fitnessapp.model.Goals;
import app.fitnessapp.repository.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("goalsService")
public class GoalsServiceImpl implements GoalsService {

    @Autowired
    GoalsRepository goalsRepository;

    @Override
    public Goals getUserByGoals(String email) {
        return goalsRepository.findByEmail(email);
    }

    @Override
    public void saveUserGoals(Goals goals) {
        goalsRepository.save(goals);
    }

    @Override
    public List<Goals> getAllGoalsByEmail(String email) {
        return goalsRepository.findAll();
    }
}