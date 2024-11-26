package com.app.AidNearby.services.servicesInterfaces;
import com.app.AidNearby.domain.DTO.adsDTO.AdCategoryDTO;
import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;

import java.util.List;

import java.util.UUID;

public interface AdCategoryService {
    List<AdCategoryDTO> getAdsCategories(UUID userId);
}
