package com.app.AidNearby.domain.Entities.user;

import jakarta.persistence.Id;
import java.util.Date;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "approved_ads")
public class UserEntity {
    @Id
    private UUID userId;
    private String username;
    private String password;
    private String email;
    private Date createdAt;
    private String role; // TODO: Figure out which type this should be
    private Boolean isBanned;
    private Boolean isDeleted;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Float subsidarityAvgRating;

    //TODO: Add reviewList and favoritesAds whem they are implemented
    //TODO: Add List of Applications related to the ADs (and status of them)
    //TODO: Add List of Ads that are in progress by user
    //TODO: Add List of user's Ads


}
