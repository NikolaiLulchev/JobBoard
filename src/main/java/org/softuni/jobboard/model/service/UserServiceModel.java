package org.softuni.jobboard.model.service;

import org.softuni.jobboard.model.entity.Role;
import org.softuni.jobboard.model.entity.enums.LevelEnum;

import java.util.Set;

public class UserServiceModel {

    private Long id;
    private Integer age;
    private String email;
    private String username;
    private String password;
    private Set<Role> role;
    private LevelEnum level;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<Role> getRole() {
        return role;
    }

    public UserServiceModel setRole(Set<Role> role) {
        this.role = role;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}


