package org.softuni.jobboard.model.dto;

import org.softuni.jobboard.model.entity.TechStackEntity;
import org.softuni.jobboard.model.enums.GenderEnum;
import org.softuni.jobboard.model.enums.LevelEnum;

import java.util.List;

public class UserViewModel {

    private String username;
    private String password;
    private String email;
    private Integer age;
    private GenderEnum gender;
    private LevelEnum level;
    private List<TechStackEntity> techStack;
    private String firstName;
    private String lastName;

    public UserViewModel() {
    }

    public UserViewModel(String username, String password, String email, Integer age, GenderEnum gender,
                         LevelEnum level, List<TechStackEntity> techStack, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.level = level;
        this.techStack = techStack;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserViewModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserViewModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserViewModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public List<TechStackEntity> getTechStack() {
        return techStack;
    }

    public UserViewModel setTechStack(List<TechStackEntity> techStack) {
        this.techStack = techStack;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
