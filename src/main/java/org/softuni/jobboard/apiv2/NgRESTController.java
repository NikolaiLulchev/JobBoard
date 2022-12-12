//package org.softuni.jobboard.apiv2;
//
//import org.softuni.jobboard.model.entity.UserEntity;
//import org.softuni.jobboard.service.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v2")
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
//public class NgRESTController {
//
//    private final UserService userService;
//
//    public NgRESTController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @GetMapping
//    public String api(){
//        return "<html><body><h1>Hello from new API</h1></body></html>";
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserEntity>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
//
//    @GetMapping("/users/{id}")
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
//}
