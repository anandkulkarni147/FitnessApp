package app.fitnessapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
@Table(name = "Goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "goalType")
    private String goalType;
    @Column(name = "goalTarget")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "progess")
    private String progress;
    @Column(name = "daysleft")
    private String daysleft;
}
