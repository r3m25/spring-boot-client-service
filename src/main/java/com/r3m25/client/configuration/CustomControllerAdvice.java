package com.r3m25.client.configuration;

import com.r3m25.client.exception.BaseException;
import com.r3m25.client.exception.ExceptionDetail;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class CustomControllerAdvice {
    public CustomControllerAdvice() {

    }

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ExceptionDetail> handleAirException(BaseException ex) {
        HttpStatus status = this.resolveAnnotatedResponseStatus(ex);
        return ResponseEntity.status(status).body(this.buildExceptionDetail(status, ex.getCode(), ex));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionDetail> handle(Exception exception) {
        HttpStatus status = this.resolveAnnotatedResponseStatus(exception);
        return ResponseEntity.status(status).body(
                this.buildExceptionDetail(status, String.valueOf(status.value()), exception));
    }

    private HttpStatus resolveAnnotatedResponseStatus(Exception exception) {
        ResponseStatus annotation = AnnotatedElementUtils.findMergedAnnotation(exception.getClass(), ResponseStatus.class);
        if (annotation != null) {
            return annotation.value();
        } else {
            return !(exception instanceof MethodArgumentNotValidException) &&
                    !(exception instanceof HttpMessageNotReadableException) &&
                    !(exception instanceof MissingServletRequestParameterException) ?
                    HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.BAD_REQUEST;
        }
    }

    private ExceptionDetail buildExceptionDetail(HttpStatus status, String code, Exception ex) {
        ExceptionDetail.ExceptionDetailBuilder exceptionDetail = ExceptionDetail.builder();
        exceptionDetail.status(status);
        exceptionDetail.code(code);
        exceptionDetail.message(ex.getMessage());
        Throwable cause = ex.getCause();
        if (null != cause) {
            exceptionDetail.debugMessage(cause.getMessage());
        } else {
            exceptionDetail.debugMessage(ex.getMessage());
        }
        return exceptionDetail.build();
    }
}
