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
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AdServiceImpl implements AdService {

    private UserRepository userRepository;
    private AdRepository adRepository;
    private final GeocodingService geocodingService;
    private AdMapper adMapper;


    @Override
    @Transactional
    public AdDTO createAd(AdDTO adDTO, UUID userId) throws IOException {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        AdEntity adEntity = adMapper.mapToEntity(adDTO);
        adEntity.setUser(userEntity);
        adEntity.setAdImage(adDTO.getAdImage().getBytes());

        /*if (adDTO.getAdImage() != null) {
            try {
                // Improved Base64 validation
                if (adDTO.getAdImage().matches("^[A-Za-z0-9+/]+={0,2}$")) {
                    byte[] decodedImage = Base64.getDecoder().decode(adDTO.getAdImage());
                    adEntity.setAdImage(decodedImage);
                } else {
                    throw new IllegalArgumentException("Invalid Base64 image data");
                }
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Failed to decode Base64 image data", e);
            }
        }*/

        if (adDTO.getAdLocation() != null && !adDTO.getAdLocation().isEmpty()) {
            double[] coordinates = geocodingService.getCoordinates(adDTO.getAdLocation());
            adEntity.setLatitude(coordinates[0]);
            adEntity.setLongitude(coordinates[1]);
        }

        // Jeśli użytkownik podał współrzędne, bezpośrednio je zapisuj
        if (adDTO.getLatitude() != null && adDTO.getLongitude() != null) {
            adEntity.setLatitude(adDTO.getLatitude());
            adEntity.setLongitude(adDTO.getLongitude());
        }

        AdEntity savedAd = adRepository.save(adEntity);
        return adMapper.mapToDto(savedAd);
    }
}
