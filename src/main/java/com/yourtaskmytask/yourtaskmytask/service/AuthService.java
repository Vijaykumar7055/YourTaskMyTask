package com.yourtaskmytask.yourtaskmytask.service;

import com.yourtaskmytask.yourtaskmytask.entity.Role;
import com.yourtaskmytask.yourtaskmytask.entity.User;
import com.yourtaskmytask.yourtaskmytask.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Service

public class AuthService {
    private final UserRepository userRepository;



    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(@Valid User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        user.setRole(Role.USER);

        return userRepository.save(user);
    }

//    user login service
    public User login(com.yourtaskmytask.dto.LoginRequest loginRequest) {

        User user = userRepository
                .findByEmail(loginRequest.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password")
                );

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
    }

