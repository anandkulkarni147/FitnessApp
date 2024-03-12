package app.fitnessapp.model;

import javax.persistence.*;

@Entity
@Table(name = "Goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "goal")
    private String goal;

    @Column(name = "goalType")
    private String goalType;

    @Column(name = "activity")
    private String activity;

    @Column(name = "goalTarget")
    private Integer target;
    @Column(name = "email")
    private String email;
    @Column(name = "progress")
    private Integer progress;
    @Column(name = "daysleft")
    private Integer daysleft;

    public Goals() {

    }

    public Goals(String goal, String goalType, String activity, Integer target, String email, Integer progress, Integer daysleft) {
        this.goal = goal;
        this.goalType = goalType;
        this.activity = activity;
        this.target = target;
        this.email = email;
        this.progress = progress;
        this.daysleft = daysleft;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getDaysleft() {
        return daysleft;
    }

    public void setDaysleft(Integer daysleft) {
        this.daysleft = daysleft;
    }
}
