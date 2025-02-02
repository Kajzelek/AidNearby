package com.app.AidNearby.services.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.DTO.adsDTO.ApprovedAdsDTO;
import com.app.AidNearby.domain.DTO.userDTO.ProfileDataDTO;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.AdMapper;
import com.app.AidNearby.mappers.impl.UserMapper;
import com.app.AidNearby.repository.AdRepository;
import com.app.AidNearby.repository.UserRepository;
import com.app.AidNearby.services.servicesInterfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Set<ApprovedAdsDTO> getAidsProvided(UUID userId) {
        return Set.of();
    }

    @Override
    public Set<ApprovedAdsDTO> getActiveAids(UUID userId) {
        return Set.of();
    }

    @Override
    public Set<ApprovedAdsDTO> getCompletedAids(UUID userId) {
        return Set.of();
    }

    @Override
    public String fillOutProfile(ProfileDataDTO profileDataDTO, UUID userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        userEntity.setFirstName(profileDataDTO.getFirstName());
        userEntity.setLastName(profileDataDTO.getLastName());
        userEntity.setPhoneNumber(profileDataDTO.getPhoneNumber());
        userEntity.setAddress(profileDataDTO.getAddress());
        userEntity.setProfilePicture(profileDataDTO.getProfilePicture());
        userEntity.setBio(profileDataDTO.getBio());
        userEntity.setAge(profileDataDTO.getAge());
        userEntity.setInterests(profileDataDTO.getInterests());

        userRepository.save(userEntity);
        return "Profile filled out successfully";
    }

}
