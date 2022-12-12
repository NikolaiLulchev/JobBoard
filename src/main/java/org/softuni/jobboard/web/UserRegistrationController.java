package org.softuni.jobboard.web;

import org.softuni.jobboard.model.dto.UserRegisterDTO;
import org.softuni.jobboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true"
)
@Controller
@RequestMapping("/users")
public class UserRegistrationController {

  private final UserService userService;

  public UserRegistrationController(UserService userService) {
    this.userService = userService;
  }

  @ModelAttribute("userModel")
  public UserRegisterDTO initUserModel() {
    return new UserRegisterDTO();
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @PostMapping("/register")
  public String register(@Valid UserRegisterDTO userModel,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("userModel", userModel);
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
              bindingResult);
      return "redirect:/users/register";
    }
    this.userService.registerAndLogin(userModel);

    return "redirect:/home";
  }
}
