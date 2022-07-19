package org.softuni.jobboard.model.entity;

import org.softuni.jobboard.model.enums.GenderEnum;
import org.softuni.jobboard.model.enums.LevelEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column
    private String email;
    @Column
    private Integer age;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRoleEntity> role = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TechStackEntity> techStack = new ArrayList<>();
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    public UserEntity() {
    }


    public List<TechStackEntity> getTechStack() {
        return techStack;
    }

    public UserEntity setTechStack(List<TechStackEntity> techStack) {
        this.techStack = techStack;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserEntity setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public Set<UserRoleEntity> getRole() {
        return role;
    }

    public UserEntity setRole(Set<UserRoleEntity> role) {
        this.role = role;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserEntity setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
