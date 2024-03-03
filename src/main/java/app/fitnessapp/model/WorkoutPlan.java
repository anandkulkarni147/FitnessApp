package app.fitnessapp.model;

import javax.persistence.*;

@Entity
@Table(name = "workout_plans")
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // Getters and setters
}
