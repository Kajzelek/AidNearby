package com.app.AidNearby.services.servicesInterfaces;

import com.app.AidNearby.domain.DTO.adsDTO.AdApplicationDTO;

import java.util.List;
import java.util.UUID;

public interface AdApplicationService {

    AdApplicationDTO createAdApplication(AdApplicationDTO adApplicationDTO, UUID userId);

    String deleteAdApplication(UUID adApplicationId, UUID userId);

    List<AdApplicationDTO> getAdApplicationsByAdId(UUID adId);

    List<AdApplicationDTO> getAdApplicationsByUserIdAndStatus(UUID userId, String status);

    AdApplicationDTO updateAdApplicationStatus(AdApplicationDTO adApplicationDTO, UUID userId);

    boolean hasUserAppliedToAd(UUID userId, UUID adId);

    /*List<AdApplicationDTO> getAdApplications(UUID adId, UUID userId);

    List<AdApplicationDTO> getAdApplicationsByAdCreatorId(UUID userId);
*/
}
