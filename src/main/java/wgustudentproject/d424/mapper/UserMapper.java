package wgustudentproject.d424.mapper;

import wgustudentproject.d424.dto.UserDTO;
import wgustudentproject.d424.entity.Project;
import wgustudentproject.d424.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());


        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO){
        User user = new User();

        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());


        return user;
    }
}
