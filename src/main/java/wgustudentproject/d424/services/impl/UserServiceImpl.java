package wgustudentproject.d424.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wgustudentproject.d424.dto.UserDTO;
import wgustudentproject.d424.entity.User;
import wgustudentproject.d424.exception.ResourceNotFoundExceptionCustom;
import wgustudentproject.d424.mapper.UserMapper;
import wgustudentproject.d424.repository.UserRepository;
import wgustudentproject.d424.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        User createdUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(createdUser);
    }

    @Override
    public UserDTO getUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("User not found")
        );

        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUsers(int userId, UserDTO userDTO) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("User not found.")
        );

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User updatedUser = userRepository.save(user);

        return UserMapper.mapToUserDTO(updatedUser);
    }


    @Override
    public void deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("User not found.")
        );

        user.setRoles(null);

        userRepository.save(user);

        userRepository.delete(user);
    }


}
