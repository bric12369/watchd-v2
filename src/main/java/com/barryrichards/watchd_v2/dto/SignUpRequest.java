package com.barryrichards.watchd_v2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
    @Email
    String email,

    @NotBlank
    String username,
    
    @Size(min = 8)
    String password
) {}
