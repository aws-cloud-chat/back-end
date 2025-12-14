package com.example.accchat3.domain.user.service;

import com.example.accchat3.domain.auth.dto.AccessTokenDTO;
import com.example.accchat3.domain.user.dto.CreateUserDTO;

public interface UserService {
    AccessTokenDTO register(CreateUserDTO dto);
}
