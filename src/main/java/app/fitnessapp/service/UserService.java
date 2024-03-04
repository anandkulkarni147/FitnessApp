package app.fitnessapp.service;
import app.fitnessapp.model.User;

public interface UserService {
    User getUserById(Long userId);
    void saveUserDetails(Long userId, User userDetails);
}