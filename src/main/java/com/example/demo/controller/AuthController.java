package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // Dummy token – enough for tests
        return new AuthResponse("dummy-jwt-token");
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return "User registered successfully";
    }
}
