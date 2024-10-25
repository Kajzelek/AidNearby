package com.app.AidNearby.services.servicesInterfaces;
import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.DTO.adsDTO.ApprovedAdsDTO;
import com.app.AidNearby.domain.DTO.userDTO.ProfileDataDTO;


import java.util.Set;
import java.util.UUID;

public interface UserService {
    Set<ApprovedAdsDTO> getAidsProvided(UUID userId);
    Set<ApprovedAdsDTO> getActiveAids(UUID userId);
    Set<ApprovedAdsDTO> getCompletedAids(UUID userId);
    String fillOutProfile(ProfileDataDTO profileDataDTO, UUID userId);
}
