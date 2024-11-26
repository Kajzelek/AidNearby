package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdCategoryDTO;
import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AdCategoryMapper implements Mapper<AdCategoryEntity, AdCategoryDTO> {

    private final ModelMapper mapper;

    public AdCategoryMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AdCategoryDTO mapToDto(AdCategoryEntity adCategoryEntity) {
        return mapper.map(adCategoryEntity, AdCategoryDTO.class);
    }

    @Override
    public AdCategoryEntity mapToEntity(AdCategoryDTO adCategoryDTO) {
        return mapper.map(adCategoryDTO, AdCategoryEntity.class);
    }
}
