package com.example.accchat3.domain.user.service;

import com.example.accchat3.domain.auth.dto.AccessTokenDTO;
import com.example.accchat3.domain.auth.entity.User;
import com.example.accchat3.domain.user.converter.UserConverter;
import com.example.accchat3.domain.user.dto.CreateUserDTO;
import com.example.accchat3.domain.user.exception.UserException;
import com.example.accchat3.domain.user.exception.code.UserErrorCode;
import com.example.accchat3.domain.user.repository.UserReadRepository;
import com.example.accchat3.domain.user.repository.UserWriteRopository;
import com.example.accchat3.global.config.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserReadRepository userReadRepository;
    private final UserWriteRopository userWriteRopository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    // 회원가입
    public AccessTokenDTO register(CreateUserDTO dto) {

        // email, username 중복 검사
        if (userReadRepository.existsByEmail(dto.getEmail())) {
            throw new UserException(UserErrorCode.DUPLICATE_EMAIL);
        }
        if (userReadRepository.existsByUsername(dto.getUsername())) {
            throw new UserException(UserErrorCode.DUPLICATE_NICKNAME);
        }

        // userId 생성
        Integer newUserId = (int) (System.currentTimeMillis() / 1000);

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        // Converter로 Entity 변환
        User user = UserConverter.toUser(dto, newUserId, encodedPassword);

        // User 저장
        userWriteRopository.save(user);

        String token = jwtProvider.generateAccessToken(user.getUserId(), user.getUserName());

        return new AccessTokenDTO(token);
    }
}
