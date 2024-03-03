package app.fitnessapp.service;

import app.fitnessapp.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username);
}
