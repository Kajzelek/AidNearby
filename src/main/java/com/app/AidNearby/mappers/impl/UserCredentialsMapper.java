package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.userDTO.UserCredentialsDTO;
import com.app.AidNearby.domain.Entities.user.UserCredentialsEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class UserCredentialsMapper implements Mapper<UserCredentialsEntity, UserCredentialsDTO> {

    private final ModelMapper mapper;

    public UserCredentialsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserCredentialsDTO mapToDto(UserCredentialsEntity userCredentialsEntity) {
        return mapper.map(userCredentialsEntity, UserCredentialsDTO.class);
    }

    @Override
    public UserCredentialsEntity mapToEntity(UserCredentialsDTO userCredentialsDTO) {
        return mapper.map(userCredentialsDTO, UserCredentialsEntity.class);
    }

}
