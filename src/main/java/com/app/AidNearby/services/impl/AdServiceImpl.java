package com.app.AidNearby.services.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.AdMapper;
import com.app.AidNearby.repository.AdRepository;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.AdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class AdServiceImpl implements AdService {

    private UserRepository userRepository;
    private AdRepository adRepository;
    private AdMapper adMapper;

    @Override
    public AdDTO createAd(AdDTO adDTO, UUID userId) {

        UserEntity userEntity = userRepository.findById(userId).orElse(null);

        AdEntity adEntity = adMapper.mapToEntity(adDTO);

        adEntity.builder()
                .user(userEntity)
                .build();

        AdEntity savedAd = adRepository.save(adEntity);
        return adMapper.mapToDto(savedAd);
    }
}
