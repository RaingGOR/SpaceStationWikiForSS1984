package raingor.ru.userservice.mappers;

import org.springframework.stereotype.Component;
import raingor.ru.userservice.domain.User;
import raingor.ru.userservice.dto.RequestUserDTO;
import raingor.ru.userservice.dto.ResponseUserDTO;

import java.util.List;

@Component
public class UserMapper {
    public ResponseUserDTO convertToUserDTO(User user) {
        return new ResponseUserDTO(
                user.getUsername(),
                user.getEmail(),
                user.getRole().name()
        );
    }

    public List<ResponseUserDTO> convertToUserDTOs(List<User> users) {
        return users.stream()
                .map(this::convertToUserDTO)
                .toList();
    }

    public User convertToUser(RequestUserDTO userDTO) {
        return new User(
                userDTO.username(),
                userDTO.password(),
                userDTO.email()
        );
    }
}
