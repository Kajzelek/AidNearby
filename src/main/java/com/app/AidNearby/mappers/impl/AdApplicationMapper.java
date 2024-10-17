package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdApplicationDTO;
import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class AdApplicationMapper implements Mapper<AdApplicationEntity, AdApplicationDTO> {
    private final ModelMapper mapper;

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
    }
}
