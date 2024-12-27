package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.reviewsDTO.ReviewDTO;
import com.app.AidNearby.domain.Entities.reviews.ReviewEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper{
    public ReviewDTO mapToDto(ReviewEntity reviewEntity) {
        return ReviewDTO.builder()
                .adId(reviewEntity.getAdId())
                .comment(reviewEntity.getComment())
                .rating(reviewEntity.getRating())
                .reviewId(reviewEntity.getReviewId())
                .createdAt(reviewEntity.getCreatedAt())
                .userId(reviewEntity.getUser().getUserId())
                .ratedUserId(reviewEntity.getUserId())
                .build();
    }

    public ReviewEntity mapToEntity(ReviewDTO reviewDTO) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setComment(reviewDTO.getComment());
        reviewEntity.setRating(reviewDTO.getRating());
        return reviewEntity;
    }
}
