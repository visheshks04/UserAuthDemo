package com.demo.UserAuth.services;

import com.demo.UserAuth.models.User;
import com.demo.UserAuth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.UserAuth.dto.UserLoginRequest;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean isUserExists(String username) {
        return userRepository.findExistByUsername(username);
    }

    public boolean validateLogin(UserLoginRequest loginRequest) {
        User user = getUserByUsername(loginRequest.getUsername());
        return user.getPassword().equals(loginRequest.getPassword());
    }
}
