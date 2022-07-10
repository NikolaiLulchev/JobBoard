package org.softuni.jobboard.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime addedOn;
    @Column(nullable = false)
    private boolean isActive;
}
