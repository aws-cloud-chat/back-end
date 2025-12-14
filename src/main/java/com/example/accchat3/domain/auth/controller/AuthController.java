package com.example.accchat3.domain.auth.controller;

import com.example.accchat3.domain.auth.dto.AccessTokenDTO;
import com.example.accchat3.domain.user.dto.CreateUserDTO;
import com.example.accchat3.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    // 회원 가입
    @PostMapping("/register")
    public ResponseEntity<AccessTokenDTO> register(@RequestBody @Valid CreateUserDTO dto) {
        AccessTokenDTO accessToken = userService.register(dto);
        return ResponseEntity.ok(accessToken);
    }
}



