package com.app.AidNearby.repository;

import com.app.AidNearby.domain.DTO.adsDTO.AdCategoryDTO;
import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AdCategoryRepository extends JpaRepository<AdCategoryEntity, UUID> {
    List<AdCategoryEntity> findAll();
}
