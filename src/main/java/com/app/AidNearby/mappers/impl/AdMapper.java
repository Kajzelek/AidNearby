package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class AdMapper implements Mapper<AdEntity, AdDTO> {
    private final ModelMapper mapper;

    public AdMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AdDTO mapToDto(AdEntity adEntity) {
        return mapper.map(adEntity, AdDTO.class);
    }

    @Override
    public AdEntity mapToEntity(AdDTO adDTO) {
        return mapper.map(adDTO, AdEntity.class);
    }

}
