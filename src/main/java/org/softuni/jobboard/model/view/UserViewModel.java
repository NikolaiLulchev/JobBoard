package org.softuni.jobboard.model.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserViewModel {

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String gender;
    private Set<String> role = new HashSet<>();
    private String level;
    private List<String> techStack = new ArrayList<>();

    public UserViewModel() {
    }

    public UserViewModel(String firstName, String lastName, String email,
                         Integer age, String gender, Set<String> role,
                         String level, List<String> techStack) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.level = level;
        this.techStack = techStack;
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

    public String getGender() {
        return gender;
    }

    public UserViewModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Set<String> getRole() {
        return role;
    }

    public UserViewModel setRole(Set<String> role) {
        this.role = role;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public UserViewModel setLevel(String level) {
        this.level = level;
        return this;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public UserViewModel setTechStack(List<String> techStack) {
        this.techStack = techStack;
        return this;
    }
}
