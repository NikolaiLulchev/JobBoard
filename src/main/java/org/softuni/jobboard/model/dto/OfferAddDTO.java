package org.softuni.jobboard.model.dto;

import org.softuni.jobboard.model.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public class OfferAddDTO {

    private UserEntity user;

    private String title;

    private String description;

    private LocalDateTime addedOn;

    private boolean isActive;

    private String level;

    private List<String> techStack;

    public OfferAddDTO() {
    }

    public UserEntity getUser() {
        return user;
    }

    public OfferAddDTO setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OfferAddDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public OfferAddDTO setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public OfferAddDTO setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public OfferAddDTO setLevel(String level) {
        this.level = level;
        return this;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public OfferAddDTO setTechStack(List<String> techStack) {
        this.techStack = techStack;
        return this;
    }
}
