package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.reviews.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewEntity, UUID> {
    List<ReviewEntity> findByUserId(UUID userId);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM ReviewEntity r WHERE r.adApplication.adApplicationId = :adApplicationId AND r.user.userId = :userId")
    boolean existsByAdApplicationIdAndUserId(@Param("adApplicationId") UUID adApplicationId, @Param("userId") UUID userId);

    @Query("SELECT r FROM ReviewEntity r WHERE r.adApplication.adApplicationId = :adApplicationId")
    ReviewEntity findByAdApplicationId(@Param("adApplicationId") UUID adApplicationId);
}


