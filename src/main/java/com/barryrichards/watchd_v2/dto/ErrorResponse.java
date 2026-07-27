package com.barryrichards.watchd_v2.dto;

import java.time.LocalDateTime;

public record ErrorResponse(String errorCode, String message, int status, LocalDateTime timestamp, String path) {
    
}
