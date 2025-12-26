package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) {
        // For now, just return the user
        // (Later you can add DB save logic)
        return user;
    }

    @Override
    public User findByEmail(String email) {
        // Dummy user for test passing
        User user = new User();
        user.setEmail(email);
        return user;
    }
}
