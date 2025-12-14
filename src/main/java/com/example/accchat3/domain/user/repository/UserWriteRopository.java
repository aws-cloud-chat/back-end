package com.example.accchat3.domain.user.repository;

import com.example.accchat3.domain.auth.entity.User;

public interface UserWriteRopository {
    void save(User user);
    User findById(Integer userId);
}
