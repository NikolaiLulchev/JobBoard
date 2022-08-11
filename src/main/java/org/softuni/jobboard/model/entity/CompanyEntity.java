package org.softuni.jobboard.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String name;

    public CompanyEntity() {
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }
}
