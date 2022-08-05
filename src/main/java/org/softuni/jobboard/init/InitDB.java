package org.softuni.jobboard.init;

import org.softuni.jobboard.service.TechStackService;
import org.softuni.jobboard.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements CommandLineRunner {
    private final UserService userService;
    private final TechStackService techStackService;


    public InitDB(UserService userService, TechStackService techStackService) {
        this.userService = userService;
        this.techStackService = techStackService;
    }

    @Override
    public void run(String... args) throws Exception {
        //Initialization of UserRole
        userService.initializeRoles();
        //Initialization of TechStack
        techStackService.initializeTechStack();
        //Initialize admin
        userService.initializeAdminUser();
    }
}