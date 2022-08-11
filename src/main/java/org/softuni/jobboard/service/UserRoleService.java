package org.softuni.jobboard.service;

import org.softuni.jobboard.model.entity.UserRoleEntity;
import org.softuni.jobboard.model.enums.UserRoleEnum;
import org.softuni.jobboard.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            Arrays.stream(UserRoleEnum.values()).map(r -> {
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                userRoleEntity.setRole(r);
                return userRoleEntity;
            }).forEach(userRoleRepository::save);
        }
    }

}
