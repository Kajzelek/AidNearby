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
                .submittedAt(adApplicationEntity.getSubmittedAt())
                .userMessage(adApplicationEntity.getUserMessage())
                .build();
    }

    public AdApplicationEntity mapToEntity(AdApplicationDTO adApplicationDTO) {
        AdApplicationEntity adApplicationEntity = new AdApplicationEntity();
        adApplicationEntity.setAdId(adApplicationDTO.getAdId());
        adApplicationEntity.setSubmittedAt(adApplicationDTO.getSubmittedAt());
        adApplicationEntity.setUserMessage(adApplicationDTO.getUserMessage());
        return adApplicationEntity;
    }
}
