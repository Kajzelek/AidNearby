package com.app.AidNearby.domain.Entities.reviews;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    private UUID reviewId;
    private UUID userId;
    private UUID ratedUserId;
    private UUID adId;
    private int rating;
    private String comment;
    private Date craetedAt;
}
