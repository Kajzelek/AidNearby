package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.ads.AdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdRepository extends JpaRepository<AdEntity, UUID> {
    //AdEntity findByTitle(String title);
}
