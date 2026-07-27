package com.barryrichards.watchd_v2.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.barryrichards.watchd_v2.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(e.getErrorCode(), e.getMessage(), e.getStatus().value(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(error, e.getStatus());
    }
}
