package app.fitnessapp.service;

import app.fitnessapp.model.User;
import app.fitnessapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public void saveUserDetails(Long userId, User userDetails) {
        userRepository.save(userDetails);
    }
}
