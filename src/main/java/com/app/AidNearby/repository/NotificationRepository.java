package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.chat.MessageEntity;
import com.app.AidNearby.domain.Entities.notifications.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    List<NotificationEntity> findByUser_UserId(UUID userUserId);
}
