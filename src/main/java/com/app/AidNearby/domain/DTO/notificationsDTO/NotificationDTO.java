package com.app.AidNearby.domain.DTO.notificationsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDTO {
    private String notificationType;
    private String notificationMessage;
    private Boolean isRead;
    private Date createdAt;
}
