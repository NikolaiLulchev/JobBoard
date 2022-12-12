package org.softuni.jobboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true"
)
@Controller
public class HomeController {


    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/home")
    public String home(){return "home";}
}
