package raingor.ru.userservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import raingor.ru.userservice.repositories.UserRepository;
import raingor.ru.userservice.domain.User;
import raingor.ru.userservice.dto.ResponseUserDTO;
import raingor.ru.userservice.exceptions.UserNotFoundException;
import raingor.ru.userservice.mappers.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseUserDTO getUserById(Long id) {
        User foundedUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return userMapper.convertToUserDTO(foundedUser);
    }
}
