package org.softuni.jobboard.web;

import org.modelmapper.ModelMapper;
import org.softuni.jobboard.model.dto.UserUpdateDTO;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.model.view.UserViewModel;
import org.softuni.jobboard.service.TechStackService;
import org.softuni.jobboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final TechStackService techStackService;

    public UserController(UserService userService, ModelMapper modelMapper, TechStackService techStackService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.techStackService = techStackService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile/{id}")
    public String loadProfile(@PathVariable Long id, Principal principal, Model model) {
//        String username = principal.getName();
        UserEntity user = userService.getUserById(id);
        UserViewModel userViewModel = modelMapper.map(user, UserViewModel.class);
        userViewModel.setRole(user.getRole().stream().map(r -> r.getRole().name()).collect(Collectors.toSet()));
//        UserViewModel userViewModel = new UserViewModel(
//                user.getFirstName(),
//                user.getLastName(),
//                user.getEmail(),
//                user.getAge(),
//                user.getGender().name(),
//                user.getRole().stream().map(r -> r.getRole().name()).collect(Collectors.toSet()),
//                user.getLevel().name(),
//                user.getTechStack().stream().map(ts -> ts.getTechStack().name()).collect(Collectors.toList())
//        );

        model.addAttribute("userViewModel", userViewModel);

        return "profile";
    }

    @PatchMapping("/profile/{id}")
    public String Profile(@PathVariable Long id, @Valid UserUpdateDTO userUpdateDTO, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        UserEntity user = userService.getUserById(id);

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userViewModel", userUpdateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/profile/{id}";
        }

        userService.updateUser(user, userUpdateDTO);
        return "redirect:/users/profile/{id}";
    }

    @ModelAttribute("userViewModel")
    private UserViewModel userViewModel() {
        return new UserViewModel();
    }
}
