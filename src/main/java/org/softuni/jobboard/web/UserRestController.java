package org.softuni.jobboard.web;

import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long userId) {
//        Optional<UserEntity> userOpt = Optional.ofNullable(userService.getUserById(userId));
//        if (userOpt.isEmpty()) {
//            return ResponseEntity.
//                    notFound().
//                    build();
//        } else {
//            return ResponseEntity.
//                    ok(userOpt.get());
//        }
//    }
}
