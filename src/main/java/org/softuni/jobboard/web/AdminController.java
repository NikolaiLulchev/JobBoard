package org.softuni.jobboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true"
)
@Controller
@RequestMapping("/admin-panel")
public class AdminController {

    @GetMapping()
    String adminPanel() {
        return "admin-panel";
    }
}
