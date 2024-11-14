package com.example.userAuthentification.service;



import com.example.userAuthentification.entity.User;
import com.example.userAuthentification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider jwtService;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public String save(User user) {
        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername());

        return token;
    }
    public String generateToken(String username) {
        return jwtService.generateToken(username);

    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
