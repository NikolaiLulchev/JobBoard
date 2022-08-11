package org.softuni.jobboard.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String name;
    @OneToMany
    private Set<UserEntity> users = new HashSet<>();
    @OneToMany(mappedBy = "company")
    private Set<OfferEntity> offers = new HashSet<>();

    public CompanyEntity() {
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public CompanyEntity setUsers(Set<UserEntity> user) {
        this.users = user;
        return this;
    }

    public Set<OfferEntity> getOffers() {
        return offers;
    }

    public CompanyEntity setOffers(Set<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }
}
