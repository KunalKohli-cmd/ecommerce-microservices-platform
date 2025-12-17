package com.kunal.AuthService.Service;

import com.kunal.AuthService.DTO.UserCreationRequest;
import com.kunal.AuthService.Entity.Role;
import com.kunal.AuthService.Entity.User;
import com.kunal.AuthService.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
    }

    public void saveUser(UserCreationRequest userCreationRequest){
        Optional<User> existing = userRepository.findByEmail(userCreationRequest.email());
        if(existing.isEmpty()){
            userRepository.save(new User(userCreationRequest.email(),
                    passwordEncoder.encode(userCreationRequest.password()),
                    Role.valueOf(userCreationRequest.role().toUpperCase()),
                    true));
        }else
            throw new RuntimeException("User Already Exists");
    }
}
