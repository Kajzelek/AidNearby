package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AdRepository extends JpaRepository<AdEntity, UUID> {
    //AdEntity findByTitle(String title);

    AdEntity findByAdId(UUID adId);

    @Query("SELECT a FROM AdEntity a " +
            "WHERE a.adCategory = :category " +
            "AND (6371 * acos(cos(radians(:latitude)) * cos(radians(a.latitude)) " +
            "* cos(radians(a.longitude) - radians(:longitude)) " +
            "+ sin(radians(:latitude)) * sin(radians(a.latitude)))) <= :radius")
    List<AdEntity> findAdsByCategoryAndDistance(
            @Param("category") String category,
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude,
            @Param("radius") Double radius
    );
}
