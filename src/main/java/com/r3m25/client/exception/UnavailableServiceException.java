package com.r3m25.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class UnavailableServiceException extends BaseException {
    public UnavailableServiceException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
