package com.kunal.AuthService.Repository;

import java.util.Optional;

import com.kunal.AuthService.Entity.RefreshToken;
import com.kunal.AuthService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByUser(User user);
}