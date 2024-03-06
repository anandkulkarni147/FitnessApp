package app.fitnessapp.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPService {

    private Map<String, String> otpMap = new HashMap<>();

    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public void storeOTP(String email, String otp) {
        otpMap.put(email, otp);
    }

    public boolean verifyOTP(String email, String otp) {
        if (otpMap.containsKey(email) && otpMap.get(email).equals(otp)) {
            otpMap.remove(email); // Remove OTP after successful verification
            return true;
        }
        return false;
    }
}
