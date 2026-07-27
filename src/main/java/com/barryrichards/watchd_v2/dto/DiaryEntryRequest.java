package com.barryrichards.watchd_v2.dto;
import java.util.UUID;

public record DiaryEntryRequest(
    UUID accountId,
    String tmdbId,
    double rating,
    String reviewText
) {
}
