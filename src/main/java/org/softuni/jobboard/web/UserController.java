package org.softuni.jobboard.web;

import org.softuni.jobboard.model.dto.UserViewModel;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
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

        model.addAttribute("userViewModel", userViewModel);

        return "profile";
    }
}
