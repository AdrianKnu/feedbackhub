package com.knuppelholz.feedbackhub.security;

import com.knuppelholz.feedbackhub.dto.*;

import com.knuppelholz.feedbackhub.entity.Role;
import com.knuppelholz.feedbackhub.entity.User;
import com.knuppelholz.feedbackhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.STUDENT)
                .build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
    
    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        var user = userRepository.findByEmail(request.email()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
    
}
