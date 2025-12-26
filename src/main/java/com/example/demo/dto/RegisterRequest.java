package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    // optional; defaults to STAFF in service
    private String role;
}
