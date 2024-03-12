package app.fitnessapp.repository;

import app.fitnessapp.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalsRepository extends JpaRepository<Goals, Long> {
    Goals findByEmail(String email);

    @Override
    List<Goals> findAll();
}