package com.app.AidNearby.services.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdApplicationDTO;
import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.AdApplicationMapper;
import com.app.AidNearby.repository.AdApplicationRepository;
import com.app.AidNearby.repository.AdRepository;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.AdApplicationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class AdApplicationServiceImpl implements AdApplicationService {

    private final AdApplicationRepository adApplicationRepository;
    private final AdApplicationMapper adApplicationMapper;
    private final AdRepository adRepository;
    private final UserRepository userRepository;

    @Override
    public AdApplicationDTO createAdApplication(AdApplicationDTO adApplicationDTO, UUID userId) {

        AdEntity adEntity = adRepository.findById(adApplicationDTO.getAdId())
                .orElseThrow(() -> new RuntimeException("Ad not found with ID: " + adApplicationDTO.getAdId()));

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        AdApplicationEntity adApplicationEntity = adApplicationMapper.mapToEntity(adApplicationDTO);

        adApplicationEntity.setUserId(adEntity.getUser().getUserId());
        adApplicationEntity.setUser(userEntity); //?
        AdApplicationEntity savedEntity = adApplicationRepository.save(adApplicationEntity);
        return adApplicationMapper.mapToDto(savedEntity);
    }

    @Override
    public String deleteAdApplication(UUID adApplicationId, UUID userId) {
        AdApplicationEntity adApplicationEntity = adApplicationRepository.findById(adApplicationId)
                .orElseThrow(() -> new RuntimeException("Ad application not found with ID: " + adApplicationId));

        if (!adApplicationEntity.getUserId().equals(userId)) {
            throw new RuntimeException("User is not authorized to delete this ad application");
        }

        adApplicationRepository.deleteById(adApplicationId);
        return "Ad application deleted successfully";
    }

    @Override
    public List<AdApplicationDTO> getAdApplications(UUID adId, UUID userId) {
        return adApplicationRepository.findByAdIdAndUserId(adId, userId)
                .stream()
                .map(adApplicationMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdApplicationDTO> getAdApplicationsByAdCreatorId(UUID userId) {
        return adApplicationRepository.findByUserId(userId)
                .stream()
                .map(adApplicationMapper::mapToDto)
                .collect(Collectors.toList());
    }

}