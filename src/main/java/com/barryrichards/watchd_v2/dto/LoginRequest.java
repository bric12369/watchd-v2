package com.barryrichards.watchd_v2.dto;

public record LoginRequest(
    String email,
    String password
) {}