package org.softuni.jobboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true"
)
@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/maintenance")
    public String maintenance() {
        return  "maintenance";
    }





}
