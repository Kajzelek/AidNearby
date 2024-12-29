package com.app.AidNearby.controllers.ReviewController;

import com.app.AidNearby.domain.DTO.reviewsDTO.ReviewDTO;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import com.app.AidNearby.services.impl.ReviewServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewServiceImpl reviewService;
    private final JWTserviceImpl jWTserviceImpl;

    @PostMapping("/createReview")
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO,
                                                  @RequestParam UUID adApplicationId,
                                                  @RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        ReviewDTO review = reviewService.createReview(reviewDTO, adApplicationId, userId);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/getReviewsByUserId")
    public ResponseEntity<List<ReviewDTO>> getReviewsByUserId(@RequestParam UUID userId) {
        List<ReviewDTO> reviews = reviewService.getReviewsByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/getReviewByAdApplicationId")
    public ResponseEntity<ReviewDTO> getReviewByAdApplicationId(@RequestParam UUID adApplicationId) {
        ReviewDTO review = reviewService.getReviewByAdApplicationId(adApplicationId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/updateReview")
    public ResponseEntity<ReviewDTO> updateReview(@RequestBody ReviewDTO reviewDTO,
                                                  @RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        ReviewDTO review = reviewService.updateReview(reviewDTO, userId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/deleteReview")
    public ResponseEntity<String> deleteReview(@RequestParam UUID reviewId,
                                               @RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        String response = reviewService.deleteReview(reviewId, userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/checkIfUserReviewed")
    public ResponseEntity<Boolean> checkIfUserReviewed(@RequestParam UUID adApplicationId,
                                                       @RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        boolean response = reviewService.checkIfUserReviewed(adApplicationId, userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
