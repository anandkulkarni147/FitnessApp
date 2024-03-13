package app.fitnessapp.controller;

import app.fitnessapp.model.User;
import app.fitnessapp.service.EmailService;
import app.fitnessapp.service.OTPService;
import app.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private OTPService otpService;

    @PostMapping("/sendotp")
    public ResponseEntity<String> sendOTP(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        String otp = otpService.generateOTP();
        otpService.storeOTP(email, otp);
        emailService.sendOTP(email, otp);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, Object> requestBody) {
        String email = (String) requestBody.get("email");
        String otp = (String) requestBody.get("otp");
        User existingUser = userService.getUserByEmail(email);
        if (otpService.verifyOTP(email, otp)) {
            if (existingUser != null) {
                // OTP verification successful
                return new ResponseEntity<>("ok", HttpStatus.OK);
            } else {
                // User does not exist
                return new ResponseEntity<>("Invalid email or OTP", HttpStatus.NOT_FOUND);
            }
        } else {
            // OTP verification failed
            return new ResponseEntity<>("Invalid OTP", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.saveUserDetails(user);
            return new ResponseEntity<>("ok", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userProfile")
    public ResponseEntity<User> saveUserDetails(@RequestParam("email") String email) {
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
