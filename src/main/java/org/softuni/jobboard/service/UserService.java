package org.softuni.jobboard.service;

import org.modelmapper.ModelMapper;
import org.softuni.jobboard.model.dto.UserRegisterDTO;
import org.softuni.jobboard.model.dto.UserUpdateDTO;
import org.softuni.jobboard.model.entity.TechStackEntity;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.model.entity.UserRoleEntity;
import org.softuni.jobboard.model.enums.LevelEnum;
import org.softuni.jobboard.model.enums.TechStackEnum;
import org.softuni.jobboard.model.enums.UserRoleEnum;
import org.softuni.jobboard.model.mapper.UserMapper;
import org.softuni.jobboard.model.view.UserViewModel;
import org.softuni.jobboard.repository.TechStackRepository;
import org.softuni.jobboard.repository.UserRepository;
import org.softuni.jobboard.repository.UserRoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final TechStackRepository techStackRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, TechStackRepository techStackRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, UserDetailsService userDetailsService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.techStackRepository = techStackRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userDetailsService = userDetailsService;
        this.modelMapper = modelMapper;
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

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<UserEntity> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    //    @Transactional
    public void updateUser(UserEntity user, UserUpdateDTO userUpdateDTO) {
//        modelMapper.map(userUpdateDTO, UserEntity.class);
        Set<UserRoleEntity> userRoleEntitySet = new HashSet<>();
        for (String role : userUpdateDTO.getRole()) {
            UserRoleEntity userRoleEntity = userRoleRepository.findFirstByRole(UserRoleEnum.valueOf(role));
            userRoleEntitySet.add(userRoleEntity.setRole(UserRoleEnum.valueOf(role)));
        }
        List<TechStackEntity> userTechStackList = new ArrayList<>();
        for (String stack : userUpdateDTO.getTechStack()) {
            TechStackEntity techStackEntity = techStackRepository.findByTechStack(TechStackEnum.valueOf(stack));
            userTechStackList.add(techStackEntity.setTechStack(TechStackEnum.valueOf(stack)));
        }


        user.setFirstName(userUpdateDTO.getFirstName())
                .setLastName(userUpdateDTO.getLastName())
                .setEmail(userUpdateDTO.getEmail())
                .setAge(userUpdateDTO.getAge())
                .setGender(userUpdateDTO.getGender())
                .setRole(userRoleEntitySet)
                .setLevel(LevelEnum.valueOf(userUpdateDTO.getLevel()))
                .setTechStack(userTechStackList);
        userRepository.save(user);
    }

    private UserViewModel map(UserEntity user) {

        return new UserViewModel(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getGender().name(),
                user.getRole().stream().map(e -> e.getRole().name()).collect(Collectors.toSet()),
                user.getLevel().name(),
                user.getTechStack().stream().map(ts -> ts.getTechStack().name()).collect(Collectors.toList())
        );
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

    public void initializeTechStack() {
        if (techStackRepository.count() == 0) {
            Arrays.stream(TechStackEnum.values()).map(t -> {
                TechStackEntity techStack = new TechStackEntity();
                techStack.setTechStack(t);
                return techStack;
            }).forEach(techStackRepository::save);
        }
    }
}
