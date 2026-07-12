package com.example.java_spring.modules.auth.repository;

import com.example.java_spring.common.generic.BaseRepository;
import com.example.java_spring.modules.auth.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

