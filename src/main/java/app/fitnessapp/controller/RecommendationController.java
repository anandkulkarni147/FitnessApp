package app.fitnessapp.controller;

import app.fitnessapp.model.User;
import app.fitnessapp.service.RecommendationService;
import app.fitnessapp.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RecommendationController {

    @Autowired
    UserService userService;

    @GetMapping("/recommendations")
    public ResponseEntity<Map<String, Object>> generateRecommendation(@RequestParam String email) {
        try {
            User user = userService.getUserByEmail(email);
            String curr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            int age = Integer.parseInt(curr.split("-")[0])-Integer.parseInt(user.getBirthdate().split("-")[0]);
            double height = Double.parseDouble(user.getHeightFt())*12 + Double.parseDouble(user.getHeightIn());
            double bmi = (Double.parseDouble(user.getWeight()) / (height*height))*703;

            Map<String, Object> workout = null;
            if (age >= 18 && age <= 30) {
                workout = RecommendationService.createJsonWorkoutFor18To30();
            } else {
                if (age > 30 && age <= 45) {
                    workout = RecommendationService.createJsonWorkoutFor30To45();
                } else {
                    workout = RecommendationService.createJsonWorkoutForAbove45();
                }
            }
            workout.put("bmi", bmi);
            return new ResponseEntity<>(workout, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
