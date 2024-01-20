package com.demo.UserAuth.controllers;

import com.demo.UserAuth.models.User;
import com.demo.UserAuth.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.UserAuth.services.UserService;
import com.demo.UserAuth.dto.UserLoginRequest;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        if (userService.isUserExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists. Please choose a different one.");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest loginRequest) {

        if (!userService.validateLogin(loginRequest)){
            return ResponseEntity.badRequest().body("Wrong credentials");
        }

        final String token = jwtService.buildToken(loginRequest.getUsername());

        return ResponseEntity.ok("Token: "+token);
    }
}
