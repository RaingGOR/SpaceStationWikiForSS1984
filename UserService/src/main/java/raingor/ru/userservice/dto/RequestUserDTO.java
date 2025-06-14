package raingor.ru.userservice.dto;

public record RequestUserDTO(
        String username,
        String email,
        String password
) {
}
