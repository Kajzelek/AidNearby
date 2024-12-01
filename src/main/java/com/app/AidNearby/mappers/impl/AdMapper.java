package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

@Component
public class AdMapper {

    // Mapowanie z AdEntity do AdDTO
    public AdDTO mapToDto(AdEntity adEntity) {
        return AdDTO.builder()
                .adTitle(adEntity.getAdTitle())
                .adCategory(adEntity.getAdCategory())
                .adDescription(adEntity.getAdDescription())
                .adLocation(adEntity.getAdLocation())
                .latitude(adEntity.getLatitude())
                .longitude(adEntity.getLongitude())
                .adStatus(adEntity.getAdStatus())
                //.imagePath(adEntity.getImagePath())
                .build();
    }

    public AdEntity mapToEntity(AdDTO adDTO) throws IOException {
        AdEntity adEntity = new AdEntity();
        adEntity.setAdTitle(adDTO.getAdTitle());
        adEntity.setAdCategory(adDTO.getAdCategory());
        adEntity.setAdDescription(adDTO.getAdDescription());
        adEntity.setAdLocation(adDTO.getAdLocation());
        adEntity.setLatitude(adDTO.getLatitude());
        adEntity.setLongitude(adDTO.getLongitude());
        adEntity.setAdStatus(adDTO.getAdStatus());
        //adEntity.setImagePath(adDTO.getImagePath());

        // Obraz ustawiany w serwisie
        return adEntity;
    }
}
