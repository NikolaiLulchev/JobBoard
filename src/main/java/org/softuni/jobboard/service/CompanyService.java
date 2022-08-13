package org.softuni.jobboard.service;

import org.softuni.jobboard.model.entity.CompanyEntity;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyEntity findCompany(UserEntity user) {
        return companyRepository.findCompanyEntityByUsers(user);
    }
}
