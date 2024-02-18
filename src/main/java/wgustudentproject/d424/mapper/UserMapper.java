package wgustudentproject.d424.mapper;

import wgustudentproject.d424.dto.UserDTO;
import wgustudentproject.d424.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());

        if(user.getProjects() != null && !user.getProjects().isEmpty()){
            userDTO.setProjects(user.getProjects().stream()
                    .map(ProjectMapper::mapToProjectDTO)
                    .collect(Collectors.toList()));
        }

        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO){
        User user = new User();

        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        if(userDTO.getProjects() == null && !userDTO.getProjects().isEmpty()){
            user.setProjects(userDTO.getProjects().stream()
                    .map(ProjectMapper::mapToProject)
                    .collect(Collectors.toList()));
        }

        return user;
    }
}
