package org.softuni.jobboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/home")
    public String home(){return "home";}
}
