package raingor.ru.userservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import raingor.ru.userservice.dto.ResponseUserDTO;
import raingor.ru.userservice.services.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseUserDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
