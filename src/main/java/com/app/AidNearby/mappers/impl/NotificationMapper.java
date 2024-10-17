package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.notificationsDTO.NotificationDTO;
import com.app.AidNearby.domain.Entities.notifications.NotificationEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class NotificationMapper implements Mapper<NotificationEntity, NotificationDTO> {
    private final ModelMapper mapper;

    public NotificationMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public NotificationDTO mapToDto(NotificationEntity notificationEntity) {
        return mapper.map(notificationEntity, NotificationDTO.class);
    }

    @Override
    public NotificationEntity mapToEntity(NotificationDTO notificationDTO) {
        return mapper.map(notificationDTO, NotificationEntity.class);
    }
}
