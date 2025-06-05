package lk.ijse.cmjd108.Lost_and_Found.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd108.Lost_and_Found.dto.UserDto;
import lk.ijse.cmjd108.Lost_and_Found.entity.User;
import lk.ijse.cmjd108.Lost_and_Found.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());

        return toDto(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }
}
