package com.demo.UserAuth.controllers;

import com.demo.UserAuth.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("")
    public ResponseEntity<String> sayHello(
            @RequestHeader(value="Authorization") String authHeader,
            @RequestHeader(value="username") String username
    ){

        if (!jwtService.validateToken(authHeader, username))
            return new ResponseEntity<String>("Invalid token.", HttpStatus.UNAUTHORIZED);

        return ResponseEntity.ok("Hello from GreenStitch");
    }
}
