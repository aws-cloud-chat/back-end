package com.example.accchat3.domain.user.exception.code;

import com.example.accchat3.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {

    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "USER_404", "이미 사용중인 이메일입니다."),
    DUPLICATE_NICKNAME(HttpStatus.BAD_REQUEST, "USER_008", "이미 사용중인 사용자 이름입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
