package org.softuni.jobboard.web;

import org.modelmapper.ModelMapper;
import org.softuni.jobboard.model.dto.UserUpdateDTO;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.model.view.UserViewModel;
import org.softuni.jobboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true"
)
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile/{id}")
    public String loadProfile(@PathVariable Long id, Model model) {

        UserEntity user = userService.getUserById(id);
        UserViewModel userViewModel = modelMapper.map(user, UserViewModel.class);
        userViewModel.setRole(user.getRole().stream().map(r -> r.getRole().name()).collect(Collectors.toSet()));

        if (!model.containsAttribute("userViewModel")) {
            model.addAttribute("userViewModel", userViewModel);
        }


        return "profile";
    }

    @PatchMapping("/profile/{id}")
    public String Profile(@Valid UserUpdateDTO userViewModel, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, @PathVariable Long id) {
        UserEntity user = userService.getUserById(id);

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userViewModel", userViewModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userViewModel",
                    bindingResult);
            return "redirect:{id}";
        }

        userService.updateUser(user, userViewModel);
        return "redirect:/home";
    }
}
