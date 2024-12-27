package com.app.AidNearby.services.servicesInterfaces;
import com.app.AidNearby.domain.DTO.reviewsDTO.ReviewDTO;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    ReviewDTO createReview(ReviewDTO reviewDTO, UUID AdApplicationId, UUID userId);
    List<ReviewDTO> getReviewsByUserId(UUID userId);
    String deleteReview(UUID reviewId, UUID userId);
    ReviewDTO updateReview(ReviewDTO reviewDTO, UUID userId);
}
