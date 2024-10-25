package com.app.AidNearby.domain.Entities.reviews;

import com.app.AidNearby.domain.Entities.user.UserEntity;
import jakarta.persistence.*;
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
    @GeneratedValue(generator = "UUID")
    private UUID reviewId;
    @Column(name = "ad_creator_id")
    private UUID userId;
    private UUID ratedUserId;
    private UUID adId;
    private int rating;
    private String comment;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "rating_user_id")
    private UserEntity user;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}
