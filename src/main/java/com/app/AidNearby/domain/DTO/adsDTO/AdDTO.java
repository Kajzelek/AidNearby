package com.app.AidNearby.domain.DTO.adsDTO;

import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdDTO {
    private UUID adId;
    private UUID userId;
    private String adTitle;
    private AdCategoryEntity adCategory;
    private String adDescription;
    private String adLocation;
    private Boolean adStatus;
}
