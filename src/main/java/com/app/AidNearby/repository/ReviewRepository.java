package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.reviews.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewEntity, UUID> {
    List<ReviewEntity> findByUserId(UUID userId);
}
