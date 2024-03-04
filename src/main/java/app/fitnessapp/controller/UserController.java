package app.fitnessapp.controller;

import app.fitnessapp.model.User;
import app.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static app.fitnessapp.repository.HealthHistoryRepository.healthHistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

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

    @PostMapping("/{userId}/health-history")
    public ResponseEntity<String> saveUserHealthHistory(@PathVariable Long userId, @RequestBody String healthHistoryJson) {
        try {
            userService.saveUserHealthHistory(userId, healthHistoryJson);
            return ResponseEntity.ok().body("Health history saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save health history");
        }
    }

    @GetMapping("/{userId}/health-history")
    public ResponseEntity<String> getUserHealthHistory(@PathVariable Long userId) {
        try {
            String healthHistoryJson = userService.getUserHealthHistoryJson(userId);
            return ResponseEntity.ok().body(healthHistoryJson);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve health history");
        }
    }

    @GetMapping("/health-history")
    public ResponseEntity<String> getHealthHistory() {
        try {
            List<String> history = healthHistory();
            ObjectMapper objectMapper = new ObjectMapper();
            String healthHistoryJson =  objectMapper.writeValueAsString(history);
            return ResponseEntity.ok().body(healthHistoryJson);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve health history");
        }
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
