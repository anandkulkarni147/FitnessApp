package app.fitnessapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "weight")
    private String weight;
    @Column(name = "height")
    private String heightFt;

    @Column(name = "height")
    private String heightIn;

    @Column(name = "healthHistory", columnDefinition = "TEXT")
    private String healthHistory;

    public User() {

    }
    public User(String firstName, String lastName, String email, String birthdate, String country, String city, String state, String weight, String heightFt, String heightIn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.country = country;
        this.city = city;
        this.state = state;
        this.weight = weight;
        this.heightFt = heightFt;
        this.heightIn = heightIn;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeightFt() {
        return heightFt;
    }

    public void setHeightFt(String heightFt) {
        this.heightFt = heightFt;
    }

    public String getHeightIn() {
        return heightIn;
    }

    public void setHeightIn(String heightIn) {
        this.heightIn = heightIn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
