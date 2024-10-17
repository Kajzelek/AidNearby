package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.adsDTO.ApprovedAdsDTO;
import com.app.AidNearby.domain.Entities.ads.ApprovedAdsEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class ApprovedAdsMapper implements Mapper<ApprovedAdsEntity, ApprovedAdsDTO> {
    private final ModelMapper mapper;

    public ApprovedAdsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ApprovedAdsDTO mapToDto(ApprovedAdsEntity approvedAdsEntity) {
        return mapper.map(approvedAdsEntity, ApprovedAdsDTO.class);
    }

    @Override
    public ApprovedAdsEntity mapToEntity(ApprovedAdsDTO approvedAdsDTO) {
        return mapper.map(approvedAdsDTO, ApprovedAdsEntity.class);
    }
}
