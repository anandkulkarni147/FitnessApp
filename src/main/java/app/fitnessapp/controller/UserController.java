package app.fitnessapp.controller;

import app.fitnessapp.model.User;
import app.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import static app.fitnessapp.repository.HealthHistoryRepository.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/healthHistory")
    public ResponseEntity<List<String []>> getHealthHistory(@PathVariable Long userId) {
        return new ResponseEntity<>(Arrays.asList(medicalEvents, medicalConditions, treatments, allergies), HttpStatus.OK);
    }

    @PostMapping("/{userId}/details")
    public ResponseEntity<String> saveUserDetails(@PathVariable Long userId, @RequestBody User userDetails) {
        try {
            userService.saveUserDetails(userId, userDetails);
            return new ResponseEntity<>("User details saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save user details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
