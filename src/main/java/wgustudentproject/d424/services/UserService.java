package wgustudentproject.d424.services;

import wgustudentproject.d424.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(int userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUsers(int userId, UserDTO userDTO);

    void deleteUser(int userId);


}
