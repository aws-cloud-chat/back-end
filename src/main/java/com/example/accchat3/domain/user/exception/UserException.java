package com.example.accchat3.domain.user.exception;

import com.example.accchat3.global.apiPayload.code.BaseErrorCode;
import com.example.accchat3.global.apiPayload.exception.GeneralException;

public class UserException extends GeneralException {
    public UserException(BaseErrorCode code) {
        super(code);
    }
}
