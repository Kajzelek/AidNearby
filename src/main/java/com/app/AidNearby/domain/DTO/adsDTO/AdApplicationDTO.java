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
public class AdApplicationDTO {
    private UUID userId;
    private UUID adId;
    private String applicationStatus;
    private Date submittedAt;
    private String userMessage;
    private Boolean isApproved;
}
