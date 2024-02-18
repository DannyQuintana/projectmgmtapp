package wgustudentproject.d424.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wgustudentproject.d424.dto.ProjectDTO;
import wgustudentproject.d424.entity.Project;
import wgustudentproject.d424.exception.ResourceNotFoundExceptionCustom;
import wgustudentproject.d424.mapper.ProjectMapper;
import wgustudentproject.d424.repository.ProjectRepository;
import wgustudentproject.d424.services.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;


    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = ProjectMapper.mapToProject(projectDTO);
        Project createdProject = projectRepository.save(project);

        return ProjectMapper.mapToProjectDTO(createdProject);
    }

    @Override
    public ProjectDTO getProjectById(int userId) {
       Project project = projectRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("Project not found")
        );

        return ProjectMapper.mapToProjectDTO(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(ProjectMapper::mapToProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO updateProjects(int userId, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("Project not found")
        );
        project.setProjectTitle(projectDTO.getProjectTitle());
        project.setProjectDescription(projectDTO.getProjectDescription());

        Project updatedProject = projectRepository.save(project);

        return ProjectMapper.mapToProjectDTO(updatedProject);
    }

    @Override
    public void deleteProjects(int userId) {
        Project project = projectRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundExceptionCustom("Project not found")
        );

        projectRepository.delete(project);
    }
}
