package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.userDTO.UserDTO;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserEntity, UserDTO> {

    private final ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDTO mapToDto(UserEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserEntity mapToEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }
}
