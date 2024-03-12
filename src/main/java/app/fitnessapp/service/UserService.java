package app.fitnessapp.service;

import app.fitnessapp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserByEmail(String email);

    User getUserById(Long userId);

    void saveUserDetails(User userDetails);

}