package com.app.AidNearby.services.servicesInterfaces;


import com.app.AidNearby.domain.DTO.notificationsDTO.NotificationDTO;
import com.app.AidNearby.domain.Entities.notifications.NotificationEntity;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationEntity createNotification(UUID userId, String notificationType);
    List<NotificationDTO> getNotificationsByUserId(UUID userId);
    Boolean deleteAllNotifications(UUID userId);
    Boolean deleteNotification(UUID notificationId);
}
