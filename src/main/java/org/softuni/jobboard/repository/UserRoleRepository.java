package org.softuni.jobboard.repository;

import org.softuni.jobboard.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

   Set <UserRoleEntity> findUserRoleEntitiesByRole(String role);

}
