package org.softuni.jobboard.web;

import org.softuni.jobboard.model.dto.UserViewModel;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.model.mapper.UserMapper;
import org.softuni.jobboard.repository.UserRepository;
import org.softuni.jobboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserRepository userRepository, UserMapper userMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile/{id}")
    public String loadProfile(@PathVariable Long id, Principal principal, Model model) {
        String username = principal.getName();
        UserEntity user = userService.getUser(username);
        UserViewModel userViewModel = new UserViewModel(
                username,
                user.getPassword(),
                user.getEmail(),
                user.getAge(),
                user.getGender(),
                user.getLevel(),
                user.getTechStack(),
                user.getFirstName(),
                user.getLastName()
        );
//        UserViewModel userViewModel = userMapper.userEntityToUserViewModel(user);

        model.addAttribute("userViewModel", userViewModel);

        return "profile";
    }

    @PostMapping("/profile/{id}")
    public String Profile(@PathVariable Long id) {
        return "home";
    }

//    @DeleteMapping("/profile/{id}")
//    public String deleteProfile(@PathVariable Long id){
//        Optional<UserEntity> user = userService.getUserById(id);
//        if(user.isPresent()){
//            userRepository.delete(user.get());
//        }
//        return "home";
//    }

    @PutMapping("/profile/{id}")
    public String editProfile(@PathVariable Long id, UserViewModel userViewModel) {
        UserEntity User = userService.getUserById(id);

        userService.userUpdate(userViewModel);


        return "home";
    }
}
