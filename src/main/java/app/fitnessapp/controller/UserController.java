package app.fitnessapp.controller;

import app.fitnessapp.model.HealthHistory;
import app.fitnessapp.model.User;
import app.fitnessapp.service.EmailService;
import app.fitnessapp.service.OTPService;
import app.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private OTPService otpService;

    @PostMapping("/sendotp")
    public ResponseEntity<String> sendOTP(@RequestBody String email) {
        String otp = otpService.generateOTP();
        otpService.storeOTP(email, otp);
        emailService.sendOTP(email, otp);
        return new ResponseEntity<>("OTP sent successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> loginDetails) {
        String email = loginDetails.get("email");
        String otp = loginDetails.get("otp");
        if (otpService.verifyOTP(email, otp)) {
            // OTP verification successful
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            // OTP verification failed
            return new ResponseEntity<>("Invalid OTP", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    @GetMapping("/{userId}/healthhistory")
    public ResponseEntity<String> getUserMedicalData(@PathVariable Long userId) throws Exception {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(objectMapper.writeValueAsString(user.getHealthHistory()), HttpStatus.OK);
    }

    @GetMapping("/healthhistory")
    public ResponseEntity<String> getMedicalData(@PathVariable Long id) throws Exception {
        HealthHistory healthHistory = new HealthHistory();
        return new ResponseEntity<>(objectMapper.writeValueAsString(healthHistory.getHealthHistoryMap()), HttpStatus.OK);
    }
}
