package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdApplicationDTO;
import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AdApplicationMapper {
    /*private final ModelMapper mapper;

    public AdApplicationMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AdApplicationDTO mapToDto(AdApplicationEntity adApplicationEntity) {
        return mapper.map(adApplicationEntity, AdApplicationDTO.class);
    }

    @Override
    public AdApplicationEntity mapToEntity(AdApplicationDTO adApplicationDTO) {
        return mapper.map(adApplicationDTO, AdApplicationEntity.class);
    }*/

    public AdApplicationDTO mapToDto(AdApplicationEntity adApplicationEntity) {
        return AdApplicationDTO.builder()
                .adId(adApplicationEntity.getAdId())
                .adApplicationId(adApplicationEntity.getAdApplicationId())
                .createdAt(adApplicationEntity.getCreatedAt())
                .userMessage(adApplicationEntity.getUserMessage())
                .application_status(adApplicationEntity.getApplicationStatus())
                .adTitle(adApplicationEntity.getAdTitle())
                .applicantId(adApplicationEntity.getUser().getUserId())
                .task_progress(adApplicationEntity.getTask_progress())
                .submittedAt(adApplicationEntity.getSubmittedAt())
                .finishedAt(adApplicationEntity.getFinishedAt())
                .build();
    }

    public AdApplicationEntity mapToEntity(AdApplicationDTO adApplicationDTO) {
        AdApplicationEntity adApplicationEntity = new AdApplicationEntity();
        adApplicationEntity.setAdId(adApplicationDTO.getAdId());
        adApplicationEntity.setCreatedAt(adApplicationDTO.getCreatedAt());
        adApplicationEntity.setUserMessage(adApplicationDTO.getUserMessage());
        adApplicationEntity.setApplicationStatus(adApplicationDTO.getApplication_status());
        adApplicationEntity.setAdTitle(adApplicationDTO.getAdTitle());
        return adApplicationEntity;
    }
}
