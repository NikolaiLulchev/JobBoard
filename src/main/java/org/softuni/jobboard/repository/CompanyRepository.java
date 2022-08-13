package org.softuni.jobboard.repository;

import org.softuni.jobboard.model.entity.CompanyEntity;
import org.softuni.jobboard.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    CompanyEntity findCompanyEntityByUsers (UserEntity user);
}
