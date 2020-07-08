package com.r3m25.client.client.configuration;

import com.r3m25.client.exception.BadRequestException;
import com.r3m25.client.exception.InternalServerErrorException;
import com.r3m25.client.exception.NotFoundException;
import com.r3m25.client.exception.UnavailableServiceException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (HttpStatus.valueOf(response.status())) {
            case BAD_REQUEST:
                return new BadRequestException(String.valueOf(NOT_FOUND.value()),
                        NOT_FOUND.name(),
                        new Exception(response.request().toString()));
            case NOT_FOUND:
                return new NotFoundException(
                        String.valueOf(NOT_FOUND.value()),
                        NOT_FOUND.name(),
                        new Exception(response.request().toString()));
            case SERVICE_UNAVAILABLE:
                return new UnavailableServiceException(String.valueOf(NOT_FOUND.value()),
                        NOT_FOUND.name(),
                        new Exception(response.request().toString()));
            default:
                return new InternalServerErrorException(String.valueOf(NOT_FOUND.value()),
                        NOT_FOUND.name(),
                        new Exception(response.request().toString()));
        }
    }
}
