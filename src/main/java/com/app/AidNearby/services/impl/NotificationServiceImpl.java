package com.app.AidNearby.services.impl;

import com.app.AidNearby.Exceptions.UserNotFoundException;
import com.app.AidNearby.domain.DTO.notificationsDTO.NotificationDTO;
import com.app.AidNearby.domain.Entities.notifications.NotificationEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.NotificationMapper;
import com.app.AidNearby.repository.NotificationRepository;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    NotificationRepository notificationRepository;
    NotificationMapper notificationMapper;
    UserRepository userRepository;

    @Override
    public NotificationEntity createNotification(UUID userId, String notificationType) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        NotificationEntity notificationEntity = new NotificationEntity();

        notificationEntity.setNotificationType(notificationType);
        notificationEntity.setUser(userEntity);

        if (notificationType.equals("newAd")) {
            notificationEntity.setAdId(UUID.randomUUID());
        }


        return notificationRepository.save(notificationEntity);
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserId(UUID userId) {
        List<NotificationEntity> notificationEntities = notificationRepository.findByUser_UserId(userId);

        return notificationEntities.stream()
                .map(notificationMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteNotification(UUID notificationId) {
        notificationRepository.deleteById(notificationId);
        return true;
    }

    @Override
    public Boolean deleteAllNotifications(UUID userId) {
        List<NotificationEntity> notificationEntities = notificationRepository.findByUser_UserId(userId);
        notificationRepository.deleteAll(notificationEntities);
        return true;
    }
}
