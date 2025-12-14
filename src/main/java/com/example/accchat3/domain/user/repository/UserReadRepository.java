package com.example.accchat3.domain.user.repository;

public interface UserReadRepository {
    boolean existsByEmail(String email);           // email 중복 검사
    boolean existsByUsername(String username);     // username 중복 검사
}
