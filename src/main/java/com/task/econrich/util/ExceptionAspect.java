package com.task.econrich.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ExceptionAspect {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleBusinessLogicException(CustomException e) {
        final ErrorResponse response = ErrorResponse.of(e.getExceptionCode());

        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMisMatchException(MethodArgumentTypeMismatchException e){
        final ErrorResponse response = ErrorResponse.of(HttpStatus.BAD_REQUEST, "잘못된 파라미터 값이 입력되었습니다.");

        return new ResponseEntity<>(response, HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        final ErrorResponse response = ErrorResponse.of(HttpStatus.METHOD_NOT_ALLOWED, "잘못된 연결 경로입니다.");

        return new ResponseEntity<>(response, HttpStatus.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        final ErrorResponse response = ErrorResponse.of(HttpStatus.BAD_REQUEST, "잘못된 데이터 타입이 존재합니다.");

        return new ResponseEntity<>(response, HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        final ErrorResponse response = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, "데이터를 찾을 수 없습니다.");

        return new ResponseEntity<>(response, HttpStatus.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
