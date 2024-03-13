package app.fitnessapp.controller;

import app.fitnessapp.model.User;
import app.fitnessapp.service.RecommendationService;
import app.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RecommendationController {

    @Autowired
    UserService userService;

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @GetMapping("/recommendations")
    public ResponseEntity<Map<String, Object>> generateRecommendation(@RequestParam String email) {
        try {
            User user = userService.getUserByEmail(email);
            String curr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            int age = Integer.parseInt(curr.split("-")[0]) - Integer.parseInt(user.getBirthdate().split("-")[0]);
            double height = Double.parseDouble(user.getHeightFt()) * 12 + Double.parseDouble(user.getHeightIn());
            Double bmi = (Double.parseDouble(user.getWeight()) / (height * height)) * 703;
            bmi = round(bmi, 2);

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
