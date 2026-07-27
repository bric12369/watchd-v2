package com.barryrichards.watchd_v2.dto;
import java.util.UUID;

public record DiaryEntryRequest(
    UUID accountId,
    UUID filmId,
    double rating,
    String reviewText
) {
}
