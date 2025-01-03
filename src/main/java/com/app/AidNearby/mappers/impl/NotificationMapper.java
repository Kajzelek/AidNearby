package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.notificationsDTO.NotificationDTO;
import com.app.AidNearby.domain.Entities.notifications.NotificationEntity;
import com.app.AidNearby.mappers.Mapper;
import jakarta.persistence.Column;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper{

    public NotificationDTO mapToDto(NotificationEntity notificationEntity) {
        return NotificationDTO.builder()
                .notificationId(notificationEntity.getNotificationId())
                .notificationType(notificationEntity.getNotificationType())
                .createdAt(notificationEntity.getCreatedAt())
                .build();
    }

    public NotificationEntity mapToEntity(NotificationDTO notificationDTO) {
        return NotificationEntity.builder()
                .notificationType(notificationDTO.getNotificationType())
                .build();
    }

}
