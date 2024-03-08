package com.hn.userservice.exception.common;


import com.hn.userservice.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {
    private final HttpStatus status;
    private final ErrorResponse response;

    public ApiRequestException(HttpStatus status, ErrorResponse response) {
        this.status = status;
        this.response = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ErrorResponse getResponse() {
        return response;
    }
}
