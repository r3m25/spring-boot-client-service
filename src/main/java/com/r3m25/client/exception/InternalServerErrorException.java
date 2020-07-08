package com.r3m25.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends BaseException {
    public InternalServerErrorException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
