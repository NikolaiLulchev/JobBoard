package org.softuni.jobboard.repository;

import org.softuni.jobboard.model.entity.TechStackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechStackRepository extends JpaRepository<TechStackEntity, Long> {
}
