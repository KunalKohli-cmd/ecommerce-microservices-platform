package com.kunal.AuthService.DTO;

import com.kunal.AuthService.Entity.Role;

public record UserCreationRequest(String email, String password, String role) {
}
