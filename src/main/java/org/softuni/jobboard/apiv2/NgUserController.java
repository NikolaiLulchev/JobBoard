package org.softuni.jobboard.apiv2;

import org.softuni.jobboard.model.dto.UserLoginDTO;
import org.softuni.jobboard.model.dto.UserRegisterDTO;
import org.softuni.jobboard.model.entity.UserEntity;
import org.softuni.jobboard.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(
        origins = "http://localhost:4200",
        maxAge = 3600,
        allowCredentials = "true"
)
@RestController
@RequestMapping("/api/v2/users")

public class NgUserController {

    private final UserService userService;

    public NgUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long userId) {
        Optional<UserEntity> userOpt = Optional.ofNullable(userService.getUserById(userId));
        if (userOpt.isEmpty()) {
            return ResponseEntity.
                    notFound().
                    build();
        } else {
            return ResponseEntity.
                    ok(userOpt.get());
        }
    }

//    @PostMapping("/login")

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDTO userModel,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        this.userService.registerAndLogin(userModel);

        return ResponseEntity.ok(userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDTO userModel) {

        this.userService.login(userModel);

        return ResponseEntity.ok(userModel);
    }


}
