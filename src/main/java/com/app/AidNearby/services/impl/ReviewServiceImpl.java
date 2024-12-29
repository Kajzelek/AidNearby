package com.app.AidNearby.services.impl;

import com.app.AidNearby.Exceptions.AdApplicationNotFoundException;
import com.app.AidNearby.Exceptions.UserNotFoundException;
import com.app.AidNearby.domain.DTO.reviewsDTO.ReviewDTO;
import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.domain.Entities.reviews.ReviewEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.ReviewMapper;
import com.app.AidNearby.repository.AdApplicationRepository;
import com.app.AidNearby.repository.AdRepository;
import com.app.AidNearby.repository.ReviewRepository;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final UserRepository userRepository;
    private final AdRepository adRepository;
    private final AdApplicationRepository adApplicationRepository;
    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO, UUID adApplicationId, UUID userId) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        AdApplicationEntity adApplicationEntity = adApplicationRepository.findById(adApplicationId)
                .orElseThrow(() -> new AdApplicationNotFoundException("AdApplication not found with ID: " + adApplicationId));


        ReviewEntity reviewEntity = reviewMapper.mapToEntity(reviewDTO);
        reviewEntity.setAdApplication(adApplicationEntity);
        reviewEntity.setAdId(adApplicationEntity.getAdId());
        reviewEntity.setUser(userEntity);
        reviewEntity.setUserId(adApplicationEntity.getUserId());

        ReviewEntity savedReview = reviewRepository.save(reviewEntity);
        return reviewMapper.mapToDto(savedReview);

    }

    @Override
    public List<ReviewDTO> getReviewsByUserId(UUID userId) {
        List<ReviewEntity> reviews = reviewRepository.findByUserId(userId);

        return reviews.stream()
                .map(reviewMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @Override
    public boolean checkIfUserReviewed(UUID adApplicationId, UUID userId) {
        return reviewRepository.existsByAdApplicationIdAndUserId(adApplicationId, userId);
    }

    @Override
    public ReviewDTO getReviewByAdApplicationId(UUID adApplicationId) {
        ReviewEntity reviewEntity = reviewRepository.findByAdApplicationId(adApplicationId);
        return reviewMapper.mapToDto(reviewEntity);
    }


    @Override
    public String deleteReview(UUID reviewId, UUID userId) {
        return "";
    }

    @Override
    public ReviewDTO updateReview(ReviewDTO reviewDTO, UUID userId) {
        return null;
    }
}
