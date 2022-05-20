package org.softuni.jobboard.model.entity;


import org.softuni.jobboard.model.entity.enums.UserRoleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public Role() {
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public Role setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
