package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        // Dummy token for testing
        return "jwt-token-for-" + username;
    }

    public String extractUsername(String token) {
        // Simple extraction logic for tests
        if (token == null) {
            return null;
        }
        if (token.startsWith("jwt-token-for-")) {
            return token.substring(14);
        }
        return null;
    }

    public boolean validateToken(String token, String username) {
        return token != null && token.equals(generateToken(username));
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token-for-");
    }
}
