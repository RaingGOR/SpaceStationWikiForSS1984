package raingor.ru.userservice.dto;

public record ResponseUserDTO(
        String username,
        String email,
        String role

) {
}
