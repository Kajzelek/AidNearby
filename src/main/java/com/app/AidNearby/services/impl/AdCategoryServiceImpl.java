package com.app.AidNearby.services.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdCategoryDTO;
import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.AdCategoryMapper;
import com.app.AidNearby.repository.AdCategoryRepository;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.AdCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdCategoryServiceImpl implements AdCategoryService {

    private UserRepository userRepository;
    private AdCategoryRepository adCategoryRepository;
    private AdCategoryMapper adCategoryMapper;


    @Override
    public List<AdCategoryDTO> getAdsCategories(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        List<AdCategoryEntity> categories = adCategoryRepository.findAll();
        return categories.stream()
                .map(adCategoryMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
