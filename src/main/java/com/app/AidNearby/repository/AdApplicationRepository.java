package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AdApplicationRepository extends JpaRepository<AdApplicationEntity, UUID> {
    List<AdApplicationEntity> findAllByAdId(UUID adId);
    /*List<AdApplicationEntity> findAllByUserIdAndApplicationStatus(UUID userId, String status);*/

    @Query("SELECT a FROM AdApplicationEntity a WHERE a.user.id = :userId AND a.applicationStatus = :status")
    List<AdApplicationEntity> findByUserIdAndStatus(@Param("userId") UUID userId, @Param("status") String status);

    //boolean existsByUserIdAndAdId(UUID userId, UUID adId);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AdApplicationEntity a WHERE a.user.userId = :userId AND a.adId = :adId")
    boolean existsByUserIdAndAdId(@Param("userId") UUID userId, @Param("adId") UUID adId);
}

