package app.fitnessapp.service;

import app.fitnessapp.model.User;
import app.fitnessapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Register user logic
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username) {
        // Login user logic
        return userRepository.findByUsername(username);
    }

}
