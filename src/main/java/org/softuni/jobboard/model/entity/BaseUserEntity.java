package org.softuni.jobboard.model.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class BaseUserEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRoleEntity> role = new HashSet<>();

    public BaseUserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public BaseUserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public BaseUserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BaseUserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public BaseUserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BaseUserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<UserRoleEntity> getRole() {
        return role;
    }

    public BaseUserEntity setRole(Set<UserRoleEntity> role) {
        this.role = role;
        return this;
    }
}
