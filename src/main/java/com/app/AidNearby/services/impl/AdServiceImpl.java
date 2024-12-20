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
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AdServiceImpl implements AdService {

    private UserRepository userRepository;
    private AdRepository adRepository;
    private final GeocodingService geocodingService;
    private AdMapper adMapper;
    private final FileStorageService fileStorageService;


    @Override
    @Transactional
    public AdDTO createAd(AdDTO adDTO, UUID userId) throws IOException {

        System.out.println("AdDTO: " + adDTO);

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        AdEntity adEntity = adMapper.mapToEntity(adDTO);
        adEntity.setUser(userEntity);

        // Obsługa lokalizacji
        if (adDTO.getAdLocation() != null && !adDTO.getAdLocation().isEmpty()) {
            double[] coordinates = geocodingService.getCoordinates(adDTO.getAdLocation());
            System.out.println("Coordinates: " + coordinates[0] + ", " + coordinates[1]);
            adEntity.setLatitude(coordinates[0]);
            adEntity.setLongitude(coordinates[1]);

        }

        // Jeśli użytkownik podał współrzędne, bezpośrednio je zapisuj
        if (adDTO.getLatitude() != null && adDTO.getLongitude() != null) {
            adEntity.setLatitude(adDTO.getLatitude());
            adEntity.setLongitude(adDTO.getLongitude());
            adEntity.setAdLocation(geocodingService.getAddress(adDTO.getLatitude(), adDTO.getLongitude()));
        }

        // Obsługa pliku (jeśli został przesłany)
        /*if (file != null && !file.isEmpty()) {
            String filePath = fileStorageService.storeFile(file);
            adEntity.setImagePath(filePath); // Zakładamy, że encja ma pole na ścieżkę do pliku
        }*/

        AdEntity savedAd = adRepository.save(adEntity);
        return adMapper.mapToDto(savedAd);
    }

    @Override
    public List<AdDTO> searchAds(String category, Double latitude, Double longitude, Double radius) {
        List<AdEntity> ads = adRepository.findAdsByCategoryAndDistance(category, latitude, longitude, radius);
        return ads.stream().map(adMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public AdDTO getAdById(UUID adId) {
        AdEntity adEntity = adRepository.findById(adId)
                .orElseThrow(() -> new RuntimeException("Ad not found with ID: " + adId));
        return adMapper.mapToDto(adEntity);
    }

    @Override
    public List<AdDTO> getAdsByStatusAndUserId(String status, UUID userId) {
        List<AdEntity> ads = adRepository.findByAdStatusAndUserId(status, userId);
        return ads.stream()
                .map(adMapper::mapToDto)
                .collect(Collectors.toList());
    }


}
