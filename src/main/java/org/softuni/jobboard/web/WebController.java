package org.softuni.jobboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/offers")
    public String offers() {
        return "offers";
    }

    @GetMapping("/add-offer")
    public String addOffer() {
        return "add-offer";
    }
    @GetMapping("/users/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
