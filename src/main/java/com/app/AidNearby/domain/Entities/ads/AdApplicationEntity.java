package com.app.AidNearby.domain.Entities.ads;

import com.app.AidNearby.domain.Entities.reviews.ReviewEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_applications")
public class AdApplicationEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID adApplicationId;
    private UUID adId;
    private String adTitle;
    @Column(name = "ad_creator_id")
    private UUID userId;
    private String applicationStatus;
    private String task_progress;
    private Date submittedAt;
    private Date finishedAt;
    private Date createdAt;
    private String userMessage; //OPCJONALNE SKORO MAJĄ BYĆ WIADOMOŚCI
    //private Boolean isApproved; OPCJONALNE

    @ManyToOne
    @JoinColumn(name = "applicant_user_id")
    private UserEntity user;

    @OneToOne(mappedBy = "adApplication")
    private ReviewEntity review;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        applicationStatus = "ROZPATRYWANE";
    }
}
