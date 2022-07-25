package org.softuni.jobboard.init;

import org.softuni.jobboard.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements CommandLineRunner {
    private final UserService userService;


    public InitDB(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        //Initialization of UserRole
        userService.initializeRoles();
        //Initialization of TechStack
        userService.initializeTechStack();
    }
}