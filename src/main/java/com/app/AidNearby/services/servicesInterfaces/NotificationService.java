package com.app.AidNearby.services.servicesInterfaces;


import com.app.AidNearby.domain.DTO.notificationsDTO.NotificationDTO;
import com.app.AidNearby.domain.Entities.notifications.NotificationEntity;

import java.util.UUID;

public interface NotificationService {
    NotificationEntity createNotification(NotificationDTO notificationDTO);
    NotificationEntity getNotificationByUserId(UUID userId);
    Boolean deleteNotification(UUID notificationId);
}
