package com.app.AidNearby.controllers.NotificationControllers;

import com.app.AidNearby.domain.DTO.notificationsDTO.NotificationDTO;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import com.app.AidNearby.services.impl.NotificationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationServiceImpl notificationService;
    private final JWTserviceImpl jWTserviceImpl;

    @GetMapping("/getNotifications")
    public ResponseEntity<List<NotificationDTO>> getNotifications(@RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        List<NotificationDTO> notifications = notificationService.getNotificationsByUserId(userId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @DeleteMapping("/deleteNotification/{notificationId}")
    public ResponseEntity<?> deleteNotification(@PathVariable UUID notificationId) {
        notificationService.deleteNotification(notificationId);
        return new ResponseEntity<>("Notification deleted", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllNotifications")
    public ResponseEntity<?> deleteAllNotifications(@RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        notificationService.deleteAllNotifications(userId);
        return new ResponseEntity<>("All notifications deleted", HttpStatus.OK);
    }
}
