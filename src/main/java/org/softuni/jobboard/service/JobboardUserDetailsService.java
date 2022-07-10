package org.softuni.jobboard.service;

import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.model.entity.UserRoleEntity;
import org.softuni.jobboard.model.user.JobboardUserDetails;
import org.softuni.jobboard.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JobboardUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JobboardUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(()-> new UsernameNotFoundException("User " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {

        return new JobboardUserDetails(
                userEntity.getId(),
                userEntity.getPassword(),
                userEntity.getUsername(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.
                        getRole().
                        stream().
                        map(this::map).
                        toList()
        );
    }

    private GrantedAuthority map(UserRoleEntity userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                                          userRole.
                                                  getRole().name());
    }
}
