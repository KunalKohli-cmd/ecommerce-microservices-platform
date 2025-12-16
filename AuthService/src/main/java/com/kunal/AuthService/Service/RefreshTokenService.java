package com.kunal.AuthService.Service;

import com.kunal.AuthService.Entity.RefreshToken;
import com.kunal.AuthService.Entity.User;
import com.kunal.AuthService.Repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    public RefreshTokenService(RefreshTokenRepository repository) {
        this.repository = repository;
    }
    public String createToken(User user) {
        RefreshToken token = new RefreshToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(Instant.now().plus(7, ChronoUnit.DAYS));

        repository.save(token);
        return token.getToken();
    }
}
