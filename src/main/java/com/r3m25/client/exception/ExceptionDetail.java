package com.r3m25.client.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ExceptionDetail {

    private HttpStatus status;
    private String message;
    private String code;
    private String debugMessage;

}
