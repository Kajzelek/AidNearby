package com.app.AidNearby.domain.Entities.user;

import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.domain.Entities.ads.AdEntity;
import com.app.AidNearby.domain.Entities.reviews.ReviewEntity;
import jakarta.persistence.*;

import java.util.*;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID userId;
    private String username;
    private String password;
    private String email;
    private Date createdAt;
    private String role; // TODO: Figure out which type this should be
    private Boolean isBanned;
    private Boolean isDeleted;
    private Boolean isNewUser;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Double latitude;
    private Double longitude;
    private Float subsidarityAvgRating;
    private String profilePicture;
    private String bio;
    private int age;

    @ElementCollection
    private List<String> interests; //TODO: Check if this works
    @OneToMany(mappedBy = "user")
    private Set<AdEntity> userAds = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<AdApplicationEntity> applications = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<ReviewEntity> reviews = new HashSet<>();

    @PrePersist
    public void prePersist() {
        role = "USER";
        createdAt = new Date();
        isBanned = false;
        isDeleted = false;
        isNewUser = true;
        subsidarityAvgRating = 0.0f;
    }

    //TODO: Add reviewList and favoritesAds whem they are implemented
    //TODO: Add List of Applications related to the ADs (and status of them)
    //TODO: Add List of Ads that are in progress by user
    //TODO: Add List of user's Ads


}
