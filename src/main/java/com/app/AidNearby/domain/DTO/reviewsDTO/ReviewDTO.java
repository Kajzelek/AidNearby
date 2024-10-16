package com.app.AidNearby.domain.DTO.reviewsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private UUID reviewId;
    private UUID userId;
    private UUID adId;
    private int rating;
    private String comment;
    private Date craetedAt;
}
