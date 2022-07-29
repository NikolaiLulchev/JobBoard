package org.softuni.jobboard.repository;

import org.softuni.jobboard.model.entity.UserRoleEntity;
import org.softuni.jobboard.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

   UserRoleEntity findUserRoleEntitiesByRole(String role);
   UserRoleEntity findFirstByRole(UserRoleEnum role);

}
