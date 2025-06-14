package raingor.ru.userservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
