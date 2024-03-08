package com.hn.userservice.response;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseUtils {

    public ResponseEntity<Response> badRequest(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Response> unauthorized(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<Response> methodNotSupported(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public ResponseEntity<Response> mediaTypeNotSupported(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public ResponseEntity<Response> internalErr(ErrorResponse error) {
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Response> notSuccess(HttpStatus httpStt, ErrorResponse error) {
        return new ResponseEntity<>(error, httpStt);
    }

    public ResponseEntity<CommonResponse<Void>> ok(String msg) {
        return ResponseEntity.ok(CommonResponse.of(msg, null));
    }

    public ResponseEntity<CommonResponse<Void>> ok() {
        return ResponseEntity.ok(CommonResponse.of(StringUtils.EMPTY, null));
    }

    public <T> ResponseEntity<CommonResponse<T>> ok(T data) {
        return ResponseEntity.ok(CommonResponse.of("", data));
    }

    public <T> ResponseEntity<CommonResponse<T>> ok(String msg, T data) {
        return ResponseEntity.ok(CommonResponse.of(msg, data));
    }
}
