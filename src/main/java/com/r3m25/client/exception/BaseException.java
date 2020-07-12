package com.r3m25.client.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final String code;



    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
