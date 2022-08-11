package org.softuni.jobboard.model.entity;

public class EmployerEntity extends BaseUserEntity {


    public CompanyEntity company;

    public EmployerEntity() {
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public EmployerEntity setCompany(CompanyEntity company) {
        this.company = company;
        return this;
    }
}
