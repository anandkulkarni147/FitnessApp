package app.fitnessapp.service;
import app.fitnessapp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(Long userId);
    void saveUserDetails(Long userId, User userDetails);

}