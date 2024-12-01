package com.app.AidNearby.services.servicesInterfaces;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface AdService {
    AdDTO createAd(AdDTO adDTO, UUID userId) throws IOException;
    List<AdDTO> searchAds(String category, Double latitude, Double longitude, Double radius);
}
