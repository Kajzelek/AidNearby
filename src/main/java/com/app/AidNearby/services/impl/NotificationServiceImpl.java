package com.app.AidNearby.services.impl;

import com.app.AidNearby.domain.DTO.notificationsDTO.NotificationDTO;
import com.app.AidNearby.domain.Entities.notifications.NotificationEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.services.servicesInterfaces.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {




    @Override
    public NotificationEntity createNotification(NotificationDTO notificationDTO) {


        return null;
    }

    @Override
    public NotificationEntity getNotificationByUserId(UUID userId) {
        return null;
    }

    @Override
    public Boolean deleteNotification(UUID notificationId) {
        return null;
    }
}
