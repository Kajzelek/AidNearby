package com.app.AidNearby.services.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.AdMapper;
import com.app.AidNearby.repository.AdCategoryRepository;
import com.app.AidNearby.repository.AdRepository;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.AdService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AdServiceImpl implements AdService {

    private UserRepository userRepository;
    private AdRepository adRepository;
    private AdCategoryRepository adCategoryRepository;
    private AdMapper adMapper;

    @Override
    @Transactional
    public AdDTO createAd(AdDTO adDTO, UUID userId) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        AdEntity adEntity = adMapper.mapToEntity(adDTO);
        adEntity.setUser(userEntity);

        // Save the AdCategoryEntity if it is not already saved
        /*if (adEntity.getAdCategory() != null && adEntity.getAdCategory().getAdCategoryId() == null) {
            adEntity.setAdCategory(adCategoryRepository.save(adEntity.getAdCategory()));
        }*/

        AdEntity savedAd = adRepository.save(adEntity);
        return adMapper.mapToDto(savedAd);
    }
}
