package com.yourtaskmytask.yourtaskmytask.controller;

import com.yourtaskmytask.yourtaskmytask.entity.User;
import com.yourtaskmytask.yourtaskmytask.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {

        return authService.register(user);
    }

    @PostMapping("/login")
    public User login(@Valid @RequestBody com.yourtaskmytask.dto.LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

}
