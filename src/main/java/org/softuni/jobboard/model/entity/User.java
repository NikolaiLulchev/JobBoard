package org.softuni.jobboard.model.entity;

import org.softuni.jobboard.model.entity.enums.GenderEnum;
import org.softuni.jobboard.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

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
    private Set<Role> role;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    public User() {
    }


}
