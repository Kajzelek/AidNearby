package com.app.AidNearby.domain.Entities.notifications;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    private UUID notificationId;
    private UUID userId;
    private String notificationType;
    private String notificationMessage;
    private Boolean isRead;
    private Date createdAt;
}
