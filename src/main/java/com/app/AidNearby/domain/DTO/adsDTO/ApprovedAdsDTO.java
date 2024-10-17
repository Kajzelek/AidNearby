package com.app.AidNearby.domain.DTO.adsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApprovedAdsDTO {
    private UUID userId;
    private UUID adId;
    private Date assignedAt;
    private String taskStatus;
    private Date completedAt;
}
