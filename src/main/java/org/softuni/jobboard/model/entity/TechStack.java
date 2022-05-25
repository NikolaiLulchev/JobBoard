package org.softuni.jobboard.model.entity;

import org.softuni.jobboard.model.entity.enums.TechStackEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "tech_stack")
public class TechStack extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private TechStackEnum techStack;

    public TechStack() {
    }

    public TechStackEnum getTechStack() {
        return techStack;
    }

    public TechStack setTechStack(TechStackEnum techStack) {
        this.techStack = techStack;
        return this;
    }
}
