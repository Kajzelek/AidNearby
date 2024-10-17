package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.reviewsDTO.ReviewDTO;
import com.app.AidNearby.domain.Entities.reviews.ReviewEntity;
import com.app.AidNearby.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class ReviewMapper implements Mapper<ReviewEntity, ReviewDTO> {
    private final ModelMapper mapper;

    public ReviewMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ReviewDTO mapToDto(ReviewEntity reviewEntity) {
        return mapper.map(reviewEntity, ReviewDTO.class);
    }

    @Override
    public ReviewEntity mapToEntity(ReviewDTO reviewDTO) {
        return mapper.map(reviewDTO, ReviewEntity.class);
    }
}
