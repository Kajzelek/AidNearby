package com.app.AidNearby.services.servicesInterfaces;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;

import java.io.IOException;
import java.util.UUID;

public interface AdService {
    AdDTO createAd(AdDTO adDTO, UUID userId) throws IOException;
}
