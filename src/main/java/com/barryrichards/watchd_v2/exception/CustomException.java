package com.barryrichards.watchd_v2.exception;

import org.springframework.http.HttpStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {
    
    private String errorCode;
    private HttpStatus status;

    public CustomException(String message, String errorCode, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
