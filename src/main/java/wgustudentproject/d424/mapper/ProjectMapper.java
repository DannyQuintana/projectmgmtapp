package wgustudentproject.d424.mapper;

import wgustudentproject.d424.dto.ProjectDTO;
import wgustudentproject.d424.dto.UserDTO;
import wgustudentproject.d424.entity.Project;
import wgustudentproject.d424.entity.User;

import java.util.List;
import java.util.stream.Collectors;


public class ProjectMapper {

    public static ProjectDTO mapToProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(project.getProjectId());
        projectDTO.setProjectTitle(project.getProjectTitle());
        projectDTO.setProjectDescription(project.getProjectDescription());

        if (project.getProjectManager() != null) {
            projectDTO.setProjectManger(UserMapper.mapToUserDTO(project.getProjectManager()));
        }

        if (project.getTeamMembers() != null && !project.getTeamMembers().isEmpty()) {
            List<UserDTO> teamMembersDTO = project.getTeamMembers().stream()
                    .map(UserMapper::mapToUserDTO)
                    .collect(Collectors.toList());
            projectDTO.setTeamMembers(teamMembersDTO);
        }
        return projectDTO;
    }

    public static Project mapToProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectId(projectDTO.getProjectId());
        project.setProjectTitle(projectDTO.getProjectTitle());
        project.setProjectDescription(projectDTO.getProjectDescription());

        if (projectDTO.getProjectManger() != null) {
            project.setProjectManager(UserMapper.mapToUser(projectDTO.getProjectManger()));
        }

        if (projectDTO.getTeamMembers() != null && !projectDTO.getTeamMembers().isEmpty()) {
            List<User> teamMembers = projectDTO.getTeamMembers().stream()
                    .map(UserMapper::mapToUser)
                    .collect(Collectors.toList());
            project.setTeamMembers(teamMembers);
        }
        return project;
    }
}
