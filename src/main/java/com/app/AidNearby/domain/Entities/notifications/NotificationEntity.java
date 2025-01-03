package com.app.AidNearby.domain.Entities.notifications;

import com.app.AidNearby.domain.Entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID notificationId;

    private String notificationType;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}
