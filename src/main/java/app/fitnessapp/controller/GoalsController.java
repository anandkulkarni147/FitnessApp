package app.fitnessapp.controller;

import app.fitnessapp.model.Goals;
import app.fitnessapp.model.User;
import app.fitnessapp.service.GoalsService;
import app.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class GoalsController {

    @Autowired
    private GoalsService goalsService;

    @PostMapping("/goals")
    public ResponseEntity<String> setGoals(@RequestBody Goals goals) {
        try {
            goalsService.saveUserGoals(goals);
            return new ResponseEntity<>("Set user goals", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/goals")
    public ResponseEntity<String> getGoals(@RequestParam("email") String email) {
        try {
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register user", HttpStatus.NOT_FOUND);
        }
    }
}
