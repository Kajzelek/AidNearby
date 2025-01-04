package com.app.AidNearby.services.servicesInterfaces;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface AdService {
    AdDTO createAd(AdDTO adDTO, UUID userId) throws IOException;
    List<AdDTO> searchAds(String category, Double latitude, Double longitude, Double radius);
    List<AdDTO> searchAds(Double latitude, Double longitude, Double radius);
    List<AdDTO> searchAdsByCategoryStatus(String category, Double latitude, Double longitude, Double radius, String status);
    List<AdDTO> searchAdsByStatus(Double latitude, Double longitude, Double radius, String status);
    AdDTO getAdById(UUID adId);
    List<AdDTO> getAdsByStatusAndUserId(String status, UUID userId);
    String deleteAd(UUID adId, UUID userId);
    AdDTO closeAd(UUID adId, UUID userId);
}
