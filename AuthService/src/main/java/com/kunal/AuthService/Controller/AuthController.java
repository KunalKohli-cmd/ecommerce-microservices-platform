package com.kunal.AuthService.Controller;

import com.kunal.AuthService.DTO.LoginRequest;
import com.kunal.AuthService.DTO.TokenResponse;
import com.kunal.AuthService.Service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService authService;

    AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return authService.login(request.email(), request.password());
    }
}
