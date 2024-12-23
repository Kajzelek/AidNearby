package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.adsDTO.AdApplicationDTO;
import com.app.AidNearby.domain.DTO.userDTO.ProfileDataDTO;
import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public class ProfileDataMapper {

    public ProfileDataDTO mapToDto(UserEntity userEntity) {
        return ProfileDataDTO.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .address(userEntity.getAddress())
                .age(userEntity.getAge())
                .bio(userEntity.getBio())
                .build();

    }
}
