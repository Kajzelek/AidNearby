package com.app.AidNearby.domain.DTO.notificationsDTO;

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
public class NotificationDTO {
    private UUID notificationId;
    private UUID adId;
    private String notificationType;
    private Date createdAt;
}
