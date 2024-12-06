package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AdApplicationRepository extends JpaRepository<AdApplicationEntity, UUID> {
    List<AdApplicationEntity> findByAdIdAndUserId(UUID adId, UUID userId);
    List<AdApplicationEntity> findByUserId(UUID userId);
}
