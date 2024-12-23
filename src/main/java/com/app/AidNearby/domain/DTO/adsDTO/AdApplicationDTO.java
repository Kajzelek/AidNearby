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
    private UUID adApplicationId;
    private String adTitle;
    private Date createdAt;
    private UUID applicantId;
    private String userMessage;
    private String application_status;
    private String task_progress;
    private Date submittedAt;
    private Date finishedAt;
}
