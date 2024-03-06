package wgustudentproject.d424.mapper;

import wgustudentproject.d424.dto.ProjectDTO;
import wgustudentproject.d424.entity.Project;
import wgustudentproject.d424.entity.ProjectStatus;
import wgustudentproject.d424.entity.User;


public class ProjectMapper {


    public static ProjectDTO mapToProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(project.getProjectId());
        projectDTO.setProjectTitle(project.getProjectTitle());
        projectDTO.setProjectDescription(project.getProjectDescription());
        projectDTO.setProjectProgress(project.getProjectStatus().getStatus());
        projectDTO.setProjectCommitDate(project.getProjectCommitDate());

        if(project.getProjectManager() != null ){
            projectDTO.setProjectManagerId(project.getProjectManager().getId());
        }

        return projectDTO;
    }

    public static Project mapToProject(ProjectDTO projectDTO) {
        Project project = new Project();

        project.setProjectId(projectDTO.getProjectId());
        project.setProjectTitle(projectDTO.getProjectTitle());
        project.setProjectDescription(projectDTO.getProjectDescription());
        project.setProjectCommitDate(projectDTO.getProjectCommitDate());

        if(projectDTO.getProjectProgress() != null){
            projectDTO.setProjectProgress(projectDTO.getProjectProgress());
        } else {
            project.setProjectStatus(ProjectStatus.IN_PROGRESS);
        }

        if(projectDTO.getProjectManagerId() != null) {
            User projectManager = new User();
            projectManager.setId(projectDTO.getProjectManagerId());
            project.setProjectManager(projectManager);
        }

        return project;
    }
}
