package app.fitnessapp.controller;

import app.fitnessapp.model.HealthHistory;
import app.fitnessapp.model.User;
import app.fitnessapp.repository.UserRepository;
import app.fitnessapp.service.EmailService;
import app.fitnessapp.service.OTPService;
import app.fitnessapp.service.UserService;
import app.fitnessapp.service.UserServiceImpl;
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
    UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private OTPService otpService;

    @PostMapping("/sendotp")
    public ResponseEntity<String> sendOTP(String email) {
        String otp = otpService.generateOTP();
        otpService.storeOTP(email, otp);
        emailService.sendOTP(email, otp);
        return new ResponseEntity<>("OTP sent successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam("email") String email, @RequestParam("otp") String otp) {
        User existingUser = userRepository.findByEmail(email);
        if (otpService.verifyOTP(email, otp)) {
            if (existingUser != null) {
                // OTP verification successful
                return new ResponseEntity<>("Login successful", HttpStatus.OK);
            } else {
                // User does not exist
                return new ResponseEntity<>("Invalid email or OTP", HttpStatus.NOT_FOUND);
            }
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

    @PostMapping("/users")
    public ResponseEntity<User> saveUserDetails(@RequestBody User userDetails) {
        User savedUser = userRepository.save(userDetails);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
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
