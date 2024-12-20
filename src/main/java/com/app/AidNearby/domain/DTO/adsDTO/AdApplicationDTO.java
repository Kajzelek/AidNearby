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
    private UUID adId;
    private String adTitle;
    private Date createdAt;
    private String userMessage;
    private String application_status;

}
