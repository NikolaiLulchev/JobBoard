package org.softuni.jobboard.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.jobboard.model.entity.User;
import org.softuni.jobboard.model.service.UserServiceModel;
import org.softuni.jobboard.repository.UserRepository;
import org.softuni.jobboard.service.UserService;
import org.softuni.jobboard.util.CurrentUser;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);

        userRepository.save(user);

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setUsername(username).setId(id);

    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);

    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id).map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public boolean isNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
