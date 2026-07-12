package com.example.java_spring.modules.auth.service;

import com.example.java_spring.modules.auth.dto.LoginRequestDTO;
import com.example.java_spring.modules.auth.dto.LoginResponseDTO;
import com.example.java_spring.modules.auth.dto.UserResponseDTO;
import com.example.java_spring.modules.auth.entity.User;
import com.example.java_spring.modules.auth.repository.UserRepository;
import com.example.java_spring.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional(readOnly = true)
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Email hoặc mật khẩu không đúng"));

        if (!user.getActive()) {
            throw new RuntimeException("Tài khoản đã bị vô hiệu hóa");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Email hoặc mật khẩu không đúng");
        }

        String token = jwtUtil.generateToken(user);

        UserResponseDTO userResponse = UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .active(user.getActive())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();

        return LoginResponseDTO.builder()
                .token(token)
                .type("Bearer")
                .user(userResponse)
                .build();
    }
}

