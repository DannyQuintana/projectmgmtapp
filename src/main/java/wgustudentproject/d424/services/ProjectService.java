package wgustudentproject.d424.services;

import wgustudentproject.d424.dto.ProjectDTO;
import wgustudentproject.d424.dto.UserDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);

    ProjectDTO getProjectById(int userId);

    List<ProjectDTO> getAllProjects();

    ProjectDTO updateProjects(int userId, ProjectDTO projectDTO);

    void deleteProjects(int userId);

}
