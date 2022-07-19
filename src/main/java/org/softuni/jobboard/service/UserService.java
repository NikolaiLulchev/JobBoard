package org.softuni.jobboard.service;

import org.softuni.jobboard.model.dto.UserRegisterDTO;
import org.softuni.jobboard.model.dto.UserViewModel;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.model.mapper.UserMapper;
import org.softuni.jobboard.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserDetailsService userDetailsService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userDetailsService = userDetailsService;
    }


    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);
    }


    private void login(UserEntity userEntity) {
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(userEntity.getUsername());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }

    public UserEntity getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + "was not found"));
    }

    public void userUpdate(UserViewModel userViewModel) {
        UserEntity updateUser = userMapper.userDtoToUserEntity(userViewModel);
        this.userRepository.save(updateUser);
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
