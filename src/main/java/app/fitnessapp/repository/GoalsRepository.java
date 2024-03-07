package app.fitnessapp.repository;

import app.fitnessapp.model.Goals;
import app.fitnessapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GoalsRepository extends JpaRepository<Goals, Long>{
    Goals findByEmail(String email);
}