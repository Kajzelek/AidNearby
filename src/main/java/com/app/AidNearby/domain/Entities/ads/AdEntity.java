package com.app.AidNearby.domain.Entities.ads;

import com.app.AidNearby.domain.Entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "ads")
public class AdEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID adId;
    private String adTitle;
    @ManyToOne
    private AdCategoryEntity adCategory;
    private String adDescription;
    private String adLocation;
    private String adStatus;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}
